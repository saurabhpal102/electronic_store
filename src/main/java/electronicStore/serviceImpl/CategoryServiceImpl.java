package electronicStore.serviceImpl;

import electronicStore.dto.requestDto.CategoryRequestDto;
import electronicStore.dto.responseDto.CategoryResponseDto;
import electronicStore.exceptions.ResourceNotFoundException;
import electronicStore.mapper.CategoryMapper;
import electronicStore.model.Category;
import electronicStore.repositories.CategoryRepository;
import electronicStore.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private static final boolean isDeletedFalse = false;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = categoryMapper.categoryRequestDtoToCategory(categoryRequestDto);
        Boolean verifyDuplicate = verifyDuplicateCategoryOnAdd(category);
        if (verifyDuplicate == true) {
            category.setId(UUID.randomUUID().toString());
            category.setDeleted(isDeletedFalse);
            Category newCategory = categoryRepository.save(category);
            return categoryMapper.categoryToCategoryResponseDto(newCategory);
        } else {
            throw new ResourceNotFoundException("Category already exist");
        }
    }

    private Boolean verifyDuplicateCategoryOnAdd(Category category) {
        Category category1 = categoryRepository.findByTitleAndDeleted(category.getTitle(), isDeletedFalse);
        if (category1 != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public CategoryResponseDto updateCategory(CategoryRequestDto categoryRequestDto, String categoryId) {
        Category categoryById = categoryRepository.findByIdAndDeleted(categoryId, isDeletedFalse);
        Boolean verify = verifyDuplicateCategoryOnUpdate(categoryById, categoryId);
        Category category = null;
        if (verify == true) {
            category = categoryMapper.categoryRequestDtoToCategoryOverwrite(categoryRequestDto, categoryById);
            Category updatedCategory = categoryRepository.save(category);
            return categoryMapper.categoryToCategoryResponseDto(updatedCategory);
        } else throw new ResourceNotFoundException("Category not found");
    }

    private Boolean verifyDuplicateCategoryOnUpdate(Category category, String categoryId) {
        Category category1 = categoryRepository.findByTitleAndDeletedAndIdNot(category.getTitle(), isDeletedFalse, category.getId());
        if (category1 != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void deleteCategory(String categoryId) {
        Category categoryById = categoryRepository.findByIdAndDeleted(categoryId, isDeletedFalse);
        if (categoryById != null) {
            categoryById.setDeleted(true);
            categoryRepository.save(categoryById);
        }
    }

    @Override
    public CategoryResponseDto getCategoryById(String categoryId) {
        Category categoryById = categoryRepository.findByIdAndDeleted(categoryId, isDeletedFalse);
        log.info("categoryById :: {}",categoryById);
        if (categoryById != null) {
            return categoryMapper.categoryToCategoryResponseDto(categoryById);
        } else {
            throw new ResourceNotFoundException("Category not exist");
        }
    }

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        List<Category> allCategory = categoryRepository.findByDeleted(isDeletedFalse);
        return allCategory.stream()
                .map(categoryMapper::categoryToCategoryResponseDto).toList();

    }
}
