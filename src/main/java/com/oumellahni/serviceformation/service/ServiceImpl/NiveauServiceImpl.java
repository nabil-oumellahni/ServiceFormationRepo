package com.oumellahni.serviceformation.service.ServiceImpl;

import com.oumellahni.serviceformation.dto.EntrepriseDto;
import com.oumellahni.serviceformation.dto.NiveauDto;
import com.oumellahni.serviceformation.exception.EntityNotFoundException;
import com.oumellahni.serviceformation.exception.ErrorCodes;
import com.oumellahni.serviceformation.exception.InvalidEntityException;
import com.oumellahni.serviceformation.exception.InvalidOperationException;
import com.oumellahni.serviceformation.model.Formation;
import com.oumellahni.serviceformation.repository.FormationRepository;
import com.oumellahni.serviceformation.repository.NiveauRepository;
import com.oumellahni.serviceformation.service.NiveauService;
import com.oumellahni.serviceformation.validator.NiveauValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author N.Oumellahni
 * at 11:14 AM - 8/22/2022
 */

@Service
@Slf4j
@AllArgsConstructor
public class NiveauServiceImpl implements NiveauService {

    private NiveauRepository niveauRepository;
    private FormationRepository formationRepository;

    @Override
    public NiveauDto save(NiveauDto dto) {
        List<String> errors = NiveauValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Niveau n'est pas valide {}", errors);
            throw new InvalidEntityException(
                    "Le niveau n'est pas valide.",
                    ErrorCodes.NIVEAU_NOT_VALID,
                    errors
            );
        }
        return NiveauDto.fromEntity(niveauRepository.save(NiveauDto.toEntity(dto)));
    }

    @Override
    public NiveauDto findNiveauById(Integer id) {
        if (id == null) {
            log.error("ID  de niveau est nulle.");
            return  null;
        }
        return niveauRepository.findById(id)
                .map(NiveauDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune niveau avec ID " +id + " dans la BDD.",
                        ErrorCodes.NIVEAU_NOT_FOUND
                ));
    }

    @Override
    public NiveauDto findNiveauByTitre(String titre) {
        if (!StringUtils.hasLength(titre)) {
            log.error("TITRE de niveau est nulle.");
            return null;
        }
        return niveauRepository.findNiveauByTitre(titre)
                .map(NiveauDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune niveau avec TITRE = " + titre + " dans la BDD.",
                        ErrorCodes.NIVEAU_NOT_FOUND
                ));
    }

    @Override
    public List<NiveauDto> findAll() {
        return niveauRepository.findAll()
                .stream().map(NiveauDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID de niveau est nulle.");
            return;
        }
        List<Formation> formations = formationRepository.findAllByCategoryId(id);
        if (!formations.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer ce niveau qui est deja utilise",
                    ErrorCodes.NIVEAU_ALREADY_IN_USE);
        }
        //----------------------------------------------------------------
        // TODO : when you use unique idNiveau in all formations rows , delete the statement in bellow
        //----------------------------------------------------------------
        niveauRepository.delete(NiveauDto.toEntity(findNiveauById(id)));
    }
}
