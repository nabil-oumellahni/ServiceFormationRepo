package com.oumellahni.serviceformation.service.ServiceImpl;

import com.oumellahni.serviceformation.dto.SalleDto;
import com.oumellahni.serviceformation.exception.EntityNotFoundException;
import com.oumellahni.serviceformation.exception.ErrorCodes;
import com.oumellahni.serviceformation.exception.InvalidEntityException;
import com.oumellahni.serviceformation.repository.SalleRepository;
import com.oumellahni.serviceformation.service.SalleService;
import com.oumellahni.serviceformation.validator.SalleValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author N.Oumellahni
 * at 11:32 AM - 8/22/2022
 */

@Service
@Slf4j
@AllArgsConstructor
public class SalleServiceImpl implements SalleService {

    private SalleRepository salleRepository;

    @Override
    public SalleDto save(SalleDto dto) {
        List<String> errors = SalleValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Salle n'est pas valide {}" , dto);
            throw new InvalidEntityException(
                    "La salle n'est pas valide.",
                    ErrorCodes.SALLE_NOT_VALID,
                    errors
            );
        }
        return SalleDto.fromEntity(salleRepository.save(SalleDto.toEntity(dto)));
    }

    @Override
    public SalleDto findSalleById(Integer id) {
        if (id == null) {
            log.error("ID de la salle est vide.");
            return null;
        }
        return salleRepository.findById(id)
                .map(SalleDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune Sallle aves ID = " + id + " dans la BDD.",
                        ErrorCodes.SALLE_NOT_FOUND
                ));
    }

    @Override
    public SalleDto findSalleByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("CODE de la salle est vide.");
            return null;
        }
        return salleRepository.findSalleByCode(code)
                .map(SalleDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune Sallle aves CODE = " + code + " dans la BDD.",
                        ErrorCodes.SALLE_NOT_FOUND
                ));
    }

    @Override
    public List<SalleDto> findAllByFormationId(Integer idFormation) {
        //----------------------------------------------------------------
        //TODO :
        //----------------------------------------------------------------
        return null;
    }

    @Override
    public List<SalleDto> findAll() {
        return salleRepository.findAll()
                .stream().map(SalleDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID de la salle est nulle.");
            return;
        }
        //----------------------------------------------------------------
        //TODO :
        //----------------------------------------------------------------
        salleRepository.delete(SalleDto.toEntity(findSalleById(id)));
    }
}
