package com.oumellahni.serviceformation.controller;

import com.oumellahni.serviceformation.controller.api.CategoryApi;
import com.oumellahni.serviceformation.dto.CategoryDto;
import com.oumellahni.serviceformation.dto.FormationDto;
import com.oumellahni.serviceformation.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:22 AM - 8/24/2022
 */

@RestController
@AllArgsConstructor
public class CategoryController implements CategoryApi {

    private CategoryService categoryService;

    @Override
    public CategoryDto save(CategoryDto dto) {
        return categoryService.save(dto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findCategoryById(id);
    }

    @Override
    public CategoryDto findCategoryByCode(String code) {
        return categoryService.findCategoryByCode(code);
    }

    @Override
    public CategoryDto findCategoryByTitre(String titre) {
        return categoryService.findCategoryByTitre(titre);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);
    }
}
