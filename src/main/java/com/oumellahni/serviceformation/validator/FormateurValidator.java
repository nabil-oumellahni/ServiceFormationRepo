package com.oumellahni.serviceformation.validator;

import com.oumellahni.serviceformation.dto.FormateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 4:41 PM - 8/18/2022
 */

public class FormateurValidator {
    public static List<String> validate(FormateurDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner les champs vides de formateur");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom du formateur");
        }
        if (!StringUtils.hasLength(dto.getPrenom())) {
            errors.add("Veuillez renseigner le prenom du formateur");
        }
        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("Veuillez renseigner le Mail du formateur");
        }
        if (!StringUtils.hasLength(dto.getNumTel())) {
            errors.add("Veuillez renseigner le numero de telephone du formateur");
        }
        errors.addAll(AdresseValidator.validate(dto.getAdresse()));
        return errors;
    }
}
