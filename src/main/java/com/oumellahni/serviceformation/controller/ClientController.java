package com.oumellahni.serviceformation.controller;

import com.oumellahni.serviceformation.controller.api.ClientApi;
import com.oumellahni.serviceformation.dto.ClientDto;
import com.oumellahni.serviceformation.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 7:35 PM - 8/23/2022
 */
@RestController
@AllArgsConstructor
public class ClientController implements ClientApi {

    private ClientService clientService;

    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findClientById(id);
    }

    @Override
    public ClientDto findClientByNom(String nom) {
        return clientService.findClientByNom(nom);
    }

    @Override
    public ClientDto findClientByPrenom(String prenom) {
        return clientService.findClientByPrenom(prenom);
    }

    @Override
    public ClientDto findClientByNumTel(String numTel) {
        return clientService.findClientByNumTel(numTel);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public List<ClientDto> findAllByEntrepriseId(Integer idEntreprise) {
        return clientService.findAllByEntrepriseId(idEntreprise);
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }
}
