package com.oumellahni.serviceformation.validator;

import com.oumellahni.serviceformation.dto.SalleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 9:08 AM - 8/19/2022
 */

public class SalleValidator {

    public static List<String> validate(SalleDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner les champs vides de la salle");
            return null;
        }
        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de la salle");
        }
        if (dto.getFormation() == null || dto.getFormation().getId() == null) {
            errors.add("Veuillez selectionner une formation");
        }
        return errors;
    }
}
