package com.oumellahni.serviceformation.validator;

import com.oumellahni.serviceformation.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 4:13 PM - 8/18/2022
 */

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner les champs vides de l'entreprise");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom de l'entreprise");
        }
        if (!StringUtils.hasLength(dto.getFiliale())) {
            errors.add("Veuillez selectionner le champ de filiation");
        }
        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("Veuillez reseigner l'email de l'entreprise");
        }

        errors.addAll(AdresseValidator.validate(dto.getAdresse()));
        return errors;
    }
}
