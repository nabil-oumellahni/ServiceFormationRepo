package com.oumellahni.serviceformation.service;

import com.oumellahni.serviceformation.dto.LigneCommandeClientDto;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 11:15 AM - 8/19/2022
 */

public interface LigneCommandeClientService {

    LigneCommandeClientDto save(LigneCommandeClientDto dto);

    LigneCommandeClientDto findLigneCommandeClient(Integer id);

    List<LigneCommandeClientDto> findAllByCommandeClientId(Integer idCommandeClient);

    List<LigneCommandeClientDto> findAllByFormationId(Integer idFormation);

    List<LigneCommandeClientDto> findAll();

    void delete(Integer id);
}
