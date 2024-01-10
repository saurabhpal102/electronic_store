package electronicStore.controller;

import electronicStore.dto.requestDto.CategoryRequestDto;
import electronicStore.dto.responseDto.CategoryResponseDto;
import electronicStore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        CategoryResponseDto category = categoryService.createCategory(categoryRequestDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDto> updateCategory(
            @RequestBody CategoryRequestDto categoryRequestDto,
            @PathVariable String categoryId) {
        CategoryResponseDto categoryResponseDto = categoryService.updateCategory(categoryRequestDto, categoryId);
        return new ResponseEntity<>(categoryResponseDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable String categoryId) {
        CategoryResponseDto category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> gatAllCategory() {
        List<CategoryResponseDto> allCategory = categoryService.getAllCategory();
        return new ResponseEntity<>(allCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteById(@PathVariable String categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
