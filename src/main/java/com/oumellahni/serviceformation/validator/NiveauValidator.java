package com.oumellahni.serviceformation.validator;

import com.oumellahni.serviceformation.dto.NiveauDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 4:49 PM - 8/18/2022
 */

public class NiveauValidator {

    public static List<String> validate(NiveauDto dto) {
        List<String> errors = new ArrayList<String>();
        if (dto == null) {
            errors.add("Veuillez renseigner les champs vides de niveau");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getTitre())) {
            errors.add("Veuillez renseigner le titre de niveau");
        }
        return errors;
    }
}
