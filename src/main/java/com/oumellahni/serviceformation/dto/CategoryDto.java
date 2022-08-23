package com.oumellahni.serviceformation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oumellahni.serviceformation.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:35 AM - 8/18/2022
 */

@Data
@Builder
public class CategoryDto {

    private Integer id;

    private String code;

    private String titre;

    private String designation;

    @JsonIgnore
    private List<FormationDto> formations;

    public static CategoryDto fromEntity(Category category) {
        if (category == null) {
            return null;
        }
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .titre(category.getTitre())
                .designation(category.getDesignation())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return  null;
        }
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setTitre(categoryDto.getTitre());
        category.setDesignation(categoryDto.getDesignation());
        return category;
    }
}
