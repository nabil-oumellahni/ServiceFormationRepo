package com.oumellahni.serviceformation.validator;

import com.oumellahni.serviceformation.dto.DateFormationDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 4:33 PM - 8/18/2022
 */

public class DateFormationValidator {

    public static List<String> validate(DateFormationDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner les champs vides date formation");
            return errors;
        }
        if (dto.getDate() == null) {
            errors.add("Veuillez renseigner la date de la formation");
        }
        return errors;
    }
}
