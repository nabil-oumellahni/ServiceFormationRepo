package com.oumellahni.serviceformation.service.ServiceImpl;

import com.oumellahni.serviceformation.dto.CommandeClientDto;
import com.oumellahni.serviceformation.dto.LigneCommandeClientDto;
import com.oumellahni.serviceformation.exception.EntityNotFoundException;
import com.oumellahni.serviceformation.exception.ErrorCodes;
import com.oumellahni.serviceformation.exception.InvalidEntityException;
import com.oumellahni.serviceformation.exception.InvalidOperationException;
import com.oumellahni.serviceformation.model.*;
import com.oumellahni.serviceformation.repository.ClientRepository;
import com.oumellahni.serviceformation.repository.CommandeClientRepository;
import com.oumellahni.serviceformation.repository.FormationRepository;
import com.oumellahni.serviceformation.repository.LigneCommandeClientRepository;
import com.oumellahni.serviceformation.service.CommandeClientService;
import com.oumellahni.serviceformation.validator.CommandeClientValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author N.Oumellahni
 * at 1:11 PM - 8/22/2022
 */

@Service
@Slf4j
@AllArgsConstructor
public class CommandeClientServiceImpl implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private ClientRepository clientRepository;
    private FormationRepository formationRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Commande Client n'est pas valide {}" , dto);
            throw new InvalidEntityException(
                    "La Commande client n'est pas valide.",
                    ErrorCodes.COMMANDE_CLIENT_NOT_VALID
            );
        }

        if (dto.getId() != null && dto.isCommandeValidee()) {
            throw new InvalidOperationException("Impossible de modifier la commande lorsqu'elle est validee", ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }

        Optional<Client> client = clientRepository.findById(dto.getClient().getId());
        if (client.isEmpty()) {
            log.warn("Client with ID {} was not found in the DB", dto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec l'ID" + dto.getClient().getId() + " n'a ete trouve dans la BDD",
                    ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String> formationErrors = new ArrayList<>();

        if (dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(ligCmdClt -> {
                if (ligCmdClt.getFormation() != null) {
                    Optional<Formation> formation = formationRepository.findById(ligCmdClt.getFormation().getId());
                    if (formation.isEmpty()) {
                        formationErrors.add("La formation avec l'ID " + ligCmdClt.getFormation().getId() + " n'existe pas");
                    }
                } else {
                    formationErrors.add("Impossible d'enregistrer une commande avec une formation NULL");
                }
            });
        }

        if (!formationErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Formation n'existe pas dans la BDD", ErrorCodes.FORMATION_NOT_FOUND, formationErrors);
        }
        dto.setDateCommande(Instant.now());
        CommandeClient savedCmdClt = commandeClientRepository.save(CommandeClientDto.toEntity(dto));

        if (dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(ligCmdClt -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
                ligneCommandeClient.setCommandeClient(savedCmdClt);
//                ligneCommandeClient.(dto.getIdEntreprise());

                LigneCommandeClient savedLigneCmd = ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }
        return CommandeClientDto.fromEntity(savedCmdClt);

    }

    @Override
    public CommandeClientDto findCommandeClientById(Integer id) {
        if (id == null) {
            log.error("ID commande client est nulle.");
            return null;
        }
        return commandeClientRepository.findById(id)
                .map(CommandeClientDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande client avec ID =  " + id + " dans la BDD.",
                        ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }
//
    @Override
    public CommandeClientDto findCommandeClientByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("CODE commande client est nulle.");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(code)
                .map(CommandeClientDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande client avec CODE =  " + code + " dans la BDD.",
                        ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }
//
//    @Override
//    public List<CommandeClientDto> findAllByClientId(Integer idClient) {
//        //----------------------------------------------------------------
//        //TODO :
//        //----------------------------------------------------------------
//        return null;
//    }
//
    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll()
                .stream().map(CommandeClientDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID de commande client est nulle.");
            return;
        }
        Optional<LigneCommandeClient> ligneCommandeClients = ligneCommandeClientRepository.findAllByCommandeClientId(id);
        if (ligneCommandeClients.isPresent()) {
            throw new InvalidOperationException("Impossible de supprimer une commande client deja utilisee",
                    ErrorCodes.COMMANDE_CLIENT_ALREADY_IN_USE);
        }
        commandeClientRepository.delete(CommandeClientDto.toEntity(findCommandeClientById(id)));
    }
//
//    @Override
//    public CommandeClientDto updateClient(Integer idCommande, Integer idClient) {
//        return null;
//    }
//
//    @Override
//    public CommandeClientDto updateFormation(Integer idCommande, Integer idLigneCommande, Integer newIdFormation) {
//        return null;
//    }
//
//    @Override
//    public CommandeClientDto deleteFormation(Integer idCommande, Integer idLigneCommande) {
//        return null;
//    }

}
