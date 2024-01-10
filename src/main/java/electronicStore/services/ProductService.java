package electronicStore.services;

import electronicStore.dto.requestDto.ProductRequestDto;
import electronicStore.dto.responseDto.ProductResponseDto;
import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto productRequestDto,String categoryId);

    ProductResponseDto updateProduct(ProductRequestDto productRequestDto, String productId);

    void deleteProduct(String productId);

    ProductResponseDto getProductById(String productId);

    List<ProductResponseDto> getAllProduct();
}
