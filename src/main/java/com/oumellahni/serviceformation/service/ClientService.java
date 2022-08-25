package com.oumellahni.serviceformation.service;

import com.oumellahni.serviceformation.dto.ClientDto;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:57 AM - 8/19/2022
 */

public interface ClientService {

    ClientDto save(ClientDto dto);

    ClientDto findClientById(Integer id);

    ClientDto findClientByNom(String nom);

    ClientDto findClientByPrenom(String prenom);

    ClientDto findClientByNumTel(String numTel);

    List<ClientDto> findAllByEntrepriseId(Integer idEntreprise);

    List<ClientDto> findAll();

    void delete(Integer id);
}
