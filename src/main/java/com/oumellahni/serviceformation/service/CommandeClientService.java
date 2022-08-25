package com.oumellahni.serviceformation.service;


import com.oumellahni.serviceformation.dto.CommandeClientDto;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 11:00 AM - 8/19/2022
 */

public interface CommandeClientService {

    CommandeClientDto save(CommandeClientDto dto);

    CommandeClientDto findCommandeClientById(Integer id);

    CommandeClientDto findCommandeClientByCode(String code);

    List<CommandeClientDto> findAllByClientId(Integer idClient);

    List<CommandeClientDto> findAll();

    void delete (Integer id);

    CommandeClientDto updateClient(Integer idCommande, Integer idClient);

    CommandeClientDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer newIdArticle);

    // Delete article ==> delete LigneCommandeClient
    CommandeClientDto deleteArticle(Integer idCommande, Integer idLigneCommande);


}
