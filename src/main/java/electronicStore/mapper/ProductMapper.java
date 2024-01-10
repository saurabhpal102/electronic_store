package electronicStore.mapper;

import electronicStore.dto.requestDto.ProductRequestDto;
import electronicStore.dto.responseDto.ProductResponseDto;
import electronicStore.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
//    @Mapping(target = "addedDate", ignore = true)
    Product productRequestDtoToProduct(ProductRequestDto productRequestDto);

    ProductResponseDto productToProductResponseDto(Product product);

    @Mapping(target = "productId", ignore = true)
    Product productRequestDtoToProductOverwrite(ProductRequestDto productRequestDto, @MappingTarget Product product);
}
