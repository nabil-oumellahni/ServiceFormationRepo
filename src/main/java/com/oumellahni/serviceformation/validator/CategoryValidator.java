package com.oumellahni.serviceformation.validator;

import com.oumellahni.serviceformation.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 3:55 PM - 8/18/2022
 */

public class CategoryValidator {

    public static List<String> validate(CategoryDto categoryDto) {
        List<String> errors = new ArrayList<>();

        if (categoryDto == null) {
            errors.add("Veuillez renseigner les champs vides de categorie");
            return errors;
        }
        if (!StringUtils.hasLength(categoryDto.getCode())) {
            errors.add("Veuillez renseigner le code de la categorie");
        }
        if (!StringUtils.hasLength((categoryDto.getTitre()))) {
            errors.add("Veuillez renseigner le titre de la categorie");
        }
            return errors;
    }

}
