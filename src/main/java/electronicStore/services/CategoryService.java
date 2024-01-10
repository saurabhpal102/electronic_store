package electronicStore.services;

import electronicStore.dto.requestDto.CategoryRequestDto;
import electronicStore.dto.responseDto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto);

    CategoryResponseDto updateCategory(CategoryRequestDto categoryRequestDto, String categoryId);

    void deleteCategory(String categoryId);

    CategoryResponseDto getCategoryById(String categoryId);

    List<CategoryResponseDto> getAllCategory();
}
