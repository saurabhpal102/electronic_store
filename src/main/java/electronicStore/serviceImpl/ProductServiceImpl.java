package electronicStore.serviceImpl;

import electronicStore.dto.requestDto.ProductRequestDto;
import electronicStore.dto.responseDto.ProductResponseDto;
import electronicStore.exceptions.ResourceNotFoundException;
import electronicStore.mapper.ProductMapper;
import electronicStore.model.Category;
import electronicStore.model.Product;
import electronicStore.repositories.CategoryRepository;
import electronicStore.repositories.ProductRepository;
import electronicStore.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private static final boolean isDeletedFalse = false;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto, String categoryId) {
        Category categoryById = categoryRepository.findByIdAndDeleted(categoryId, isDeletedFalse);
        if (categoryById != null) {
            Product product = productMapper.productRequestDtoToProduct(productRequestDto);
            Boolean verifyDuplicate = verifyDuplicateProductOnAdd(product);
            if (verifyDuplicate == true) {
                product.setProductId(UUID.randomUUID().toString());
                product.setDeleted(isDeletedFalse);
                product.setAddedDate(new Date());
                product.setCategory(categoryById);
                Product newProduct = productRepository.save(product);
                return productMapper.productToProductResponseDto(newProduct);
            } else {
                throw new ResourceNotFoundException("Product already exist");
            }
        } else {
            throw new ResourceNotFoundException("Category with given id not exist");
        }
     }

    private Boolean verifyDuplicateProductOnAdd(Product product) {
        Product byTitleAndDeleted = productRepository.findByTitleAndDeleted(product.getTitle(), isDeletedFalse);
        if (byTitleAndDeleted != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public ProductResponseDto updateProduct(ProductRequestDto productRequestDto, String productId) {
        Product productById = productRepository.findByProductIdAndDeleted(productId, isDeletedFalse);
        Boolean verify = verifyDuplicateProductOnUpdate(productById, productId);
        Product product = null;
        if (verify == true) {
            product = productMapper.productRequestDtoToProductOverwrite(productRequestDto, productById);
            Product updatedProduct = productRepository.save(product);
            return productMapper.productToProductResponseDto(updatedProduct);
        } else throw new ResourceNotFoundException("Product not found");
    }

    private Boolean verifyDuplicateProductOnUpdate(Product product, String productId) {
        Product product1 = productRepository.findByTitleAndDeletedAndProductIdNot(product.getTitle(), isDeletedFalse, product.getProductId());
        if (product1 != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void deleteProduct(String productId) {
        Product productById = productRepository.findByProductIdAndDeleted(productId, isDeletedFalse);
        if (productById != null) {
            productById.setDeleted(true);
            productRepository.save(productById);
        }
    }

    @Override
    public ProductResponseDto getProductById(String productId) {
        Product productById = productRepository.findByProductIdAndDeleted(productId, isDeletedFalse);
        if (productById != null) {
            return productMapper.productToProductResponseDto(productById);
        } else {
            throw new ResourceNotFoundException("Product not exist");
        }
    }

    @Override
    public List<ProductResponseDto> getAllProduct() {
        List<Product> allProduct = productRepository.findByDeleted(isDeletedFalse);
        return allProduct.stream()
                .map(productMapper::productToProductResponseDto).toList();

    }
}
