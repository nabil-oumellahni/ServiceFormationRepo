package com.oumellahni.serviceformation.service.ServiceImpl;

import com.oumellahni.serviceformation.dto.ClientDto;
import com.oumellahni.serviceformation.dto.EntrepriseDto;
import com.oumellahni.serviceformation.exception.EntityNotFoundException;
import com.oumellahni.serviceformation.exception.ErrorCodes;
import com.oumellahni.serviceformation.exception.InvalidEntityException;
import com.oumellahni.serviceformation.exception.InvalidOperationException;
import com.oumellahni.serviceformation.model.Client;
import com.oumellahni.serviceformation.repository.ClientRepository;
import com.oumellahni.serviceformation.repository.EntrepriseRepository;
import com.oumellahni.serviceformation.service.EntrepriseService;
import com.oumellahni.serviceformation.validator.EntrepriseValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author N.Oumellahni
 * at 1:37 PM - 8/22/2022
 */

@Service
@Slf4j
@AllArgsConstructor
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;
    private ClientRepository clientRepository;

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Entreprise n'est pas valide {}", dto);
            throw new InvalidEntityException(
                    "L'entreprise n'est pas valide.",
                    ErrorCodes.ENTREPRISE_NOT_VALID,
                    errors
            );
        }
        return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(dto)));
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll()
                .stream().map(EntrepriseDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public EntrepriseDto findEntrepriseById(Integer id) {
        if (id == null) {
            log.error("ID de l'entreprise est nulle.");
            return null;
        }
        return entrepriseRepository.findById(id)
                .map(EntrepriseDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune entreprise avec ID =" + id  + " dans la BDD.",
                        ErrorCodes.ENTREPRISE_NOT_FOUND
                ));
    }

    @Override
    public EntrepriseDto findEntrepriseByNom(String nom) {
        if (! StringUtils.hasLength(nom)) {
            log.error("NOM de l'entreprise est nulle.");
            return null;
        }
        return entrepriseRepository.findEntrepriseByNom(nom)
                .map(EntrepriseDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune entreprise avec NOM =" + nom  + " dans la BDD.",
                        ErrorCodes.ENTREPRISE_NOT_FOUND
                ));
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID de l'entreprise est nulle.");
            return;
        }
        List<Client> clients = clientRepository.findAllByEntrepriseId(id);
        if (!clients.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer cette entreprise qui est deja utilise",
                    ErrorCodes.ENTREPRISE_ALREADY_IN_USE);
        }
        entrepriseRepository.delete(EntrepriseDto.toEntity(findEntrepriseById(id)));
        //---------------------------------
        // TODO :
        //---------------------------------
    }
}
