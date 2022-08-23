package com.oumellahni.serviceformation.validator;

import com.oumellahni.serviceformation.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 4:25 PM - 8/18/2022
 */

public class CommandeClientValidator {
    public static List<String> validate(CommandeClientDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner les champs vides de commande client");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (dto.getDateCommande() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }
        if (dto.getClient() == null || dto.getClient().getId() == null) {
            errors.add("Veuillez renseigner le client");
        }

        return errors;
    }

}
