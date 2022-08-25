//package com.oumellahni.serviceformation.service.ServiceImpl;
//
//import com.oumellahni.serviceformation.dto.ClientDto;
//import com.oumellahni.serviceformation.dto.CommandeClientDto;
//import com.oumellahni.serviceformation.exception.EntityNotFoundException;
//import com.oumellahni.serviceformation.exception.ErrorCodes;
//import com.oumellahni.serviceformation.exception.InvalidEntityException;
//import com.oumellahni.serviceformation.repository.CommandeClientRepository;
//import com.oumellahni.serviceformation.service.CommandeClientService;
//import com.oumellahni.serviceformation.validator.CommandeClientValidator;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author N.Oumellahni
// * at 1:11 PM - 8/22/2022
// */
//
//@Service
//@Slf4j
//@AllArgsConstructor
//public class CommandeClientServiceImpl implements CommandeClientService {
//
//    private CommandeClientRepository commandeClientRepository;
//
//    @Override
//    public CommandeClientDto save(CommandeClientDto dto) {
//        List<String> errors = CommandeClientValidator.validate(dto);
//        if (!errors.isEmpty()) {
//            log.error("Commande Client n'est pas valide {}" , dto);
//            throw new InvalidEntityException(
//                    "La Commande client n'est pas valide.",
//                    ErrorCodes.COMMANDE_CLIENT_NOT_VALID
//            );
//        }
//        return CommandeClientDto.fromEntity(commandeClientRepository.save(CommandeClientDto.toEntity(dto)));
//    }
//
//    @Override
//    public CommandeClientDto findCommandeClientById(Integer id) {
//        if (id == null) {
//            log.error("ID commande client est nulle.");
//            return null;
//        }
//        return commandeClientRepository.findById(id)
//                .map(CommandeClientDto :: fromEntity)
//                .orElseThrow(() -> new EntityNotFoundException(
//                        "Aucune commande client avec ID =  " + id + " dans la BDD.",
//                        ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
//                ));
//    }
//
//    @Override
//    public CommandeClientDto findCommandeClientByCode(String code) {
//        if (!StringUtils.hasLength(code)) {
//            log.error("CODE commande client est nulle.");
//            return null;
//        }
//        return commandeClientRepository.findCommandeClientByCode(code)
//                .map(CommandeClientDto :: fromEntity)
//                .orElseThrow(() -> new EntityNotFoundException(
//                        "Aucune commande client avec CODE =  " + code + " dans la BDD.",
//                        ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
//                ));
//    }
//
//    @Override
//    public List<CommandeClientDto> findAllByClientId(Integer idClient) {
//        //----------------------------------------------------------------
//        //TODO :
//        //----------------------------------------------------------------
//        return null;
//    }
//
//    @Override
//    public List<CommandeClientDto> findAll() {
//        return commandeClientRepository.findAll()
//                .stream().map(CommandeClientDto :: fromEntity)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void delete(Integer id) {
//        if (id == null) {
//            log.error("ID de commande client est nulle.");
//            return;
//        }
//        //----------------------------------------------------------------
//        //TODO :
//        //----------------------------------------------------------------
//        commandeClientRepository.delete(CommandeClientDto.toEntity(findCommandeClientById(id)));
//    }
//}
