package com.oumellahni.serviceformation.service.ServiceImpl;

import com.oumellahni.serviceformation.dto.FormationDto;
import com.oumellahni.serviceformation.exception.EntityNotFoundException;
import com.oumellahni.serviceformation.exception.ErrorCodes;
import com.oumellahni.serviceformation.exception.InvalidEntityException;
import com.oumellahni.serviceformation.repository.FormationRepository;
import com.oumellahni.serviceformation.service.FormationService;
import com.oumellahni.serviceformation.validator.FormationValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author N.Oumellahni
 * at 10:32 AM - 8/22/2022
 */
@Service
@Slf4j
@AllArgsConstructor
public class FormationServiceImpl implements FormationService {

    private FormationRepository formationRepository;

    @Override
    public FormationDto save(FormationDto dto) {
        System.out.println("CLientDto au niveau de FormationServiceImpl : ");
        System.out.println(dto);
        List<String> errors = FormationValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Formation est non valide {}", dto);
            throw new InvalidEntityException(
                    "La formation n'est pas valide.",
                    ErrorCodes.FORMATION_NOT_VALID,
                    errors
            );
        }
        log.info("La formation est bien enregistrer.");
        return FormationDto.fromEntity(formationRepository.save(FormationDto.toEntity(dto)));
    }

    @Override
    public FormationDto findFormationById(Integer id) {
        if (id == null) {
            log.error("ID de la formation est nulle.");
            return null;
        }
        return formationRepository.findById(id)
                .map(FormationDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune Formation avec ID = " + id + " dans la BDD.",
                        ErrorCodes.FORMATION_NOT_FOUND)
                );
    }

    @Override
    public FormationDto findFormationByTitre(String titre) {
        if (!StringUtils.hasLength(titre)) {
            log.error("TITRE de la formation est nulle.");
            return null;
        }
        return formationRepository.findFormationByTitre(titre)
                .map(FormationDto :: fromEntity)
                .orElseThrow(() ->new EntityNotFoundException(
                        "Aucune Formation avec TITRE = " + titre + " dans la BDD.",
                        ErrorCodes.FORMATION_NOT_FOUND)
                );
    }

    @Override
    public FormationDto findFormationByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("CODE de la formation est nulle.");
            return null;
        }
        return formationRepository.findFormationByCode(code)
                .map(FormationDto :: fromEntity)
                .orElseThrow(() ->new EntityNotFoundException(
                        "Aucune Formation avec CODE = " + code + " dans la BDD.",
                        ErrorCodes.FORMATION_NOT_FOUND)
                );
    }

    @Override
    public List<FormationDto> findAllByCategoryId(Integer idCategory) {
        return formationRepository.findAllByCategoryId(idCategory).stream()
                .map(FormationDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<FormationDto> findAllByFormateurId(Integer idFormateur) {
        return formationRepository.findAllByFormateurId(idFormateur).stream()
                .map(FormationDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<FormationDto> findAllByDateFormationId(Integer idDateFormation) {
        return formationRepository.findAllByDateFormationId(idDateFormation).stream()
                .map(FormationDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<FormationDto> findAll() {
        return formationRepository.findAll()
                .stream().map(FormationDto :: fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID de la formation est nulle.");
            return;
        }
        //----------------------------------------------------------------
        //TODO : thinking before coding
        //----------------------------------------------------------------
        formationRepository.delete(FormationDto.toEntity(findFormationById(id)));
    }
}
