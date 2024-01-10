package electronicStore.mapper;

import electronicStore.dto.requestDto.CategoryRequestDto;
import electronicStore.dto.responseDto.CategoryResponseDto;
import electronicStore.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category categoryRequestDtoToCategory(CategoryRequestDto categoryRequestDto);

    CategoryResponseDto categoryToCategoryResponseDto(Category category);

    @Mapping(target = "id", ignore = true)
    Category categoryRequestDtoToCategoryOverwrite(CategoryRequestDto categoryRequestDto, @MappingTarget Category category);
}
