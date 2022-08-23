package com.oumellahni.serviceformation.validator;

import com.oumellahni.serviceformation.dto.AdresseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 4:02 PM - 8/18/2022
 */

public class AdresseValidator {
    public static List<String> validate(AdresseDto adresseDto) {
        List<String> errors = new ArrayList<>();

        if (adresseDto == null) {
            errors.add("Veuillez renseigner les champs vides de l'adresse");
            return errors;
        }
        if (!StringUtils.hasLength(adresseDto.getPays())) {
            errors.add("Veuillez renseigner le pays'");
        }
        return errors;
    }
}
