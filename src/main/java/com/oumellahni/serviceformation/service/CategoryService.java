package com.oumellahni.serviceformation.service;

import com.oumellahni.serviceformation.dto.CategoryDto;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:42 AM - 8/19/2022
 */

public interface CategoryService {

    CategoryDto save(CategoryDto dto);

    CategoryDto findCategoryById(Integer id);

    CategoryDto findCategoryByCode(String code);

    CategoryDto findCategoryByTitre(String titre);

    List<CategoryDto> findAll();

    void delete(Integer id);
}
