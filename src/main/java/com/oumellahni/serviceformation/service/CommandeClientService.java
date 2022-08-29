package com.oumellahni.serviceformation.service;


import com.oumellahni.serviceformation.dto.CommandeClientDto;
import com.oumellahni.serviceformation.dto.LigneCommandeClientDto;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 11:00 AM - 8/19/2022
 */

public interface CommandeClientService {

    CommandeClientDto save(CommandeClientDto dto);

    CommandeClientDto findCommandeClientById(Integer id);

    CommandeClientDto findCommandeClientByCode(String code);

//    List<CommandeClientDto> findAllByClientId(Integer idClient);
//
    List<CommandeClientDto> findAll();
//
    void delete (Integer id);

//    CommandeClientDto updateClient(Integer idCommande, Integer idClient);
//
//    CommandeClientDto updateFormation(Integer idCommande, Integer idLigneCommande, Integer newIdFormation);
//
//    // Delete article ==> delete LigneCommandeClient
//    CommandeClientDto deleteFormation(Integer idCommande, Integer idLigneCommande);

//    List<LigneCommandeClientDto> findAllLignesCommandesClientByCommandeClientId(Integer idCommande);


}
