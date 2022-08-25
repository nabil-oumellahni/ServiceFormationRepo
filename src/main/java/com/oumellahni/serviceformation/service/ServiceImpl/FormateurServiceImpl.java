package com.oumellahni.serviceformation.service.ServiceImpl;

import com.oumellahni.serviceformation.dto.ClientDto;
import com.oumellahni.serviceformation.dto.FormateurDto;
import com.oumellahni.serviceformation.dto.FormationDto;
import com.oumellahni.serviceformation.exception.EntityNotFoundException;
import com.oumellahni.serviceformation.exception.ErrorCodes;
import com.oumellahni.serviceformation.exception.InvalidEntityException;
import com.oumellahni.serviceformation.repository.FormateurRepository;
import com.oumellahni.serviceformation.service.FormateurService;
import com.oumellahni.serviceformation.validator.FormateurValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author N.Oumellahni
 * at 12:54 PM - 8/22/2022
 */

@Service
@Slf4j
@AllArgsConstructor
public class FormateurServiceImpl implements FormateurService {

    private FormateurRepository formateurRepository;

    @Override
    public FormateurDto save(FormateurDto dto) {
        List<String> errors = FormateurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Formateur n'est pas valide {}", dto);
            throw new InvalidEntityException(
                    "Le formateur n'est pas valide.",
                    ErrorCodes.FORMATEUR_NOT_VALID,
                    errors
            );
        }
        return FormateurDto.fromEntity(formateurRepository.save(FormateurDto.toEntity(dto)));
    }

    @Override
    public FormateurDto findFormateurById(Integer id) {
        if (id == null)  {
            log.error("ID de formateur est vide.");
            return null;
        }
        return formateurRepository.findById(id)
                .map(FormateurDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun formateur avec ID = " + id + " dans la BDD.",
                        ErrorCodes.FORMATEUR_NOT_FOUND
                ));
    }

    @Override
    public FormateurDto findFormateurByNom(String nom) {
        if (!StringUtils.hasLength(nom))  {
            log.error("NOM de formateur est vide.");
            return null;
        }
        return formateurRepository.findFormateurByNom(nom)
                .map(FormateurDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun formateur avec NOM = " + nom + " dans la BDD.",
                        ErrorCodes.FORMATEUR_NOT_FOUND
                ));
    }

    @Override
    public FormateurDto findFormateurByPrenom(String prenom) {
        if (!StringUtils.hasLength(prenom))  {
            log.error("PRENOM de formateur est vide.");
            return null;
        }
        return formateurRepository.findFormateurByPrenom(prenom)
                .map(FormateurDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun formateur avec PRENOM = " + prenom + " dans la BDD.",
                        ErrorCodes.FORMATEUR_NOT_FOUND
                ));
    }

    @Override
    public FormateurDto findFormateurByNumTel(String numTel) {
        if (!StringUtils.hasLength(numTel))  {
            log.error("NUM_TEL de formateur est vide.");
            return null;
        }
        return formateurRepository.findFormateurByNumTel(numTel)
                .map(FormateurDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun formateur avec NUM_TEL = " + numTel + " dans la BDD.",
                        ErrorCodes.FORMATEUR_NOT_FOUND
                ));
    }

    @Override
    public List<FormateurDto> findAll() {
        return formateurRepository.findAll()
                .stream().map(FormateurDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID de formateur est nulle.");
            return;
        }
        //----------------------------------------------------------------
        //TODO :
        //----------------------------------------------------------------
        formateurRepository.delete(FormateurDto.toEntity(findFormateurById(id)));
    }
}
