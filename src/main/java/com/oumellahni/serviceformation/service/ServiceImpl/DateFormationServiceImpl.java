package com.oumellahni.serviceformation.service.ServiceImpl;

import com.oumellahni.serviceformation.dto.ClientDto;
import com.oumellahni.serviceformation.dto.DateFormationDto;
import com.oumellahni.serviceformation.exception.EntityNotFoundException;
import com.oumellahni.serviceformation.exception.ErrorCodes;
import com.oumellahni.serviceformation.exception.InvalidEntityException;
import com.oumellahni.serviceformation.repository.DateFormationRepository;
import com.oumellahni.serviceformation.service.DateFormationService;
import com.oumellahni.serviceformation.validator.DateFormationValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author N.Oumellahni
 * at 1:24 PM - 8/22/2022
 */

@Service
@Slf4j
@AllArgsConstructor
public class DateFormationServiceImpl implements DateFormationService {

    private DateFormationRepository dateFormationRepository;

    @Override
    public DateFormationDto save(DateFormationDto dto) {
        List<String> errors = DateFormationValidator.validate(dto);
        if (! errors.isEmpty()) {
            log.error("Date formation n'est pas valide {}" , dto);
            throw new InvalidEntityException(
                    "La date de formation n'est pas valide.",
            ErrorCodes.DATE_FORMATION_NOT_VALID,
            errors
            );
        }
        return DateFormationDto.fromEntity(dateFormationRepository.save(DateFormationDto.toEntity(dto)));
    }

    @Override
    public List<DateFormationDto> findAll() {
        return dateFormationRepository.findAll()
                .stream().map(DateFormationDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public DateFormationDto findDateFormationById(Integer id) {
        if (id == null) {
            log.error("ID de la date formation est vide.");
            return null;
        }
        return dateFormationRepository.findById(id)
                .map(DateFormationDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucune date formation avec ID " + id + " dans la BDD."));
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID de la date formation est nulle.");
            return;
        }
        //----------------------------------------------------------------
        //TODO :
        //----------------------------------------------------------------
        dateFormationRepository.delete(DateFormationDto.toEntity(findDateFormationById(id)));
    }
}
