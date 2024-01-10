package electronicStore.controller;

import electronicStore.dto.requestDto.ProductRequestDto;
import electronicStore.dto.responseDto.ProductResponseDto;
import electronicStore.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("category/{categoryId}")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto, @PathVariable("categoryId") String categoryId) {
        ProductResponseDto product = productService.createProduct(productRequestDto,categoryId);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> updateProduct(
            @RequestBody ProductRequestDto productRequestDto,
            @PathVariable String productId) {
        ProductResponseDto product = productService.updateProduct(productRequestDto, productId);
        return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> getProductId(@PathVariable String productId) {
        ProductResponseDto product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> gatAllProduct() {
        List<ProductResponseDto> allProduct = productService.getAllProduct();
        return new ResponseEntity<>(allProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteById(@PathVariable String productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
