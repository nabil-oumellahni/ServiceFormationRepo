package com.oumellahni.serviceformation.validator;

import com.oumellahni.serviceformation.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 4:05 PM - 8/18/2022
 */

public class ClientValidator {

    public static List<String> validate(ClientDto dto) {
        List<String> errors = new ArrayList<String>();
        if (dto == null) {
            errors.add("Veuillez renseigner les champs vides de client");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom du client");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getPrenom())) {
            errors.add("Veuillez renseigner le prenom du client");
        }
        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("Veuillez renseigner le Mail du client");
        }
        if (!StringUtils.hasLength(dto.getNumTel())) {
            errors.add("Veuillez renseigner le numero de telephone du client");
        }
        errors.addAll(AdresseValidator.validate(dto.getAdresse()));
        return errors;
    }
}
