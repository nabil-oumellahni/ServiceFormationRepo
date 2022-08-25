package com.oumellahni.serviceformation.service.ServiceImpl;

import com.oumellahni.serviceformation.dto.ClientDto;
import com.oumellahni.serviceformation.exception.EntityNotFoundException;
import com.oumellahni.serviceformation.exception.ErrorCodes;
import com.oumellahni.serviceformation.exception.InvalidEntityException;
import com.oumellahni.serviceformation.exception.InvalidOperationException;
import com.oumellahni.serviceformation.model.CommandeClient;
import com.oumellahni.serviceformation.repository.ClientRepository;
import com.oumellahni.serviceformation.repository.CommandeClientRepository;
import com.oumellahni.serviceformation.service.ClientService;
import com.oumellahni.serviceformation.validator.ClientValidator;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author N.Oumellahni
 * at 10:54 AM - 8/22/2022
 */
@Service
@Slf4j
@AllArgsConstructor
@ToString
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private CommandeClientRepository commandeClientRepository;

    @Override
    public ClientDto save(ClientDto dto) {
        System.out.println("CLientDto au niveau de ClientServiceImpl : ");
        System.out.println(dto);
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            System.out.println("ERRORS : " + errors.toString());
            log.error("Client n'est pas valide {}", dto);
            throw new InvalidEntityException(
                    "Le client n'est pas valide.",
                    ErrorCodes.CLIENT_NOT_VALID,
                    errors
            );
        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
    }

    @Override
    public ClientDto findClientById(Integer id) {
        if (id == null) {
            log.error("ID client est vide.");
            return null;
        }
        return clientRepository.findById(id)
                .map(ClientDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune client avec ID =  " + id + " dans la BDD.",
                        ErrorCodes.CLIENT_NOT_FOUND
                ));
    }

    @Override
    public ClientDto findClientByNom(String nom) {
        if (!StringUtils.hasLength(nom)) {
            log.error("NOM client est vide.");
            return null;
        }
        return clientRepository.findClientByNom(nom)
                .map(ClientDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune client avec NOM = " + nom + " dans la BDD.",
                        ErrorCodes.CLIENT_NOT_FOUND
                ));
    }

    @Override
    public ClientDto findClientByPrenom(String prenom) {
        if (!StringUtils.hasLength(prenom)) {
            log.error("PRENOM client est vide.");
            return null;
        }
        return clientRepository.findClientByPrenom(prenom)
                .map(ClientDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune client avec PRENOM = " + prenom + " dans la BDD.",
                        ErrorCodes.CLIENT_NOT_FOUND
                ));
    }

    @Override
    public ClientDto findClientByNumTel(String numTel) {
        if (!StringUtils.hasLength(numTel)) {
            log.error("NUM_TEL client est vide.");
            return null;
        }
        return clientRepository.findClientByNumTel(numTel)
                .map(ClientDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune client avec NUM_TEL = " + numTel + " dans la BDD",
                        ErrorCodes.CLIENT_NOT_FOUND
                ));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll()
                .stream().map(ClientDto:: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientDto> findAllByEntrepriseId(Integer idEntreprise) {
        return clientRepository.findAllByEntrepriseId(idEntreprise)
                .stream().map(ClientDto:: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID de client est nulle.");
            return;
        }
        List<CommandeClient> commandeClients = commandeClientRepository.findAllByClientId(id);
        if (!commandeClients.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un client qui a deja des commande clients",
                    ErrorCodes.CLIENT_ALREADY_IN_USE);
        }
        clientRepository.delete(ClientDto.toEntity(findClientById(id)));
    }
}
