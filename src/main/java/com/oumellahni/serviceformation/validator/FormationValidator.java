package com.oumellahni.serviceformation.validator;

import com.oumellahni.serviceformation.dto.FormationDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 3:38 PM - 8/18/2022
 */

public class FormationValidator {
    public static List<String> validate(FormationDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner les champs vides de formation");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de la formation");
        }
        if (!StringUtils.hasLength(dto.getTitre())) {
            errors.add("Veuillez renseigner le titre de la formation");
        }
        if (dto.getPrixUnitaireHt() == null) {
            errors.add("Veuillez renseigner le prix unitaire HT la formation");
        }
        if (dto.getTauxTva() == null) {
            errors.add("Veuillez renseigner le taux TVA de l'article");
        }
        if (dto.getPrixUnitaireTtc() == null) {
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
        }
        if (dto.getCategory() == null || dto.getCategory().getId() == null) {
            errors.add("Veuillez selectionner une categorie");
        }
        return errors;
    }
}
