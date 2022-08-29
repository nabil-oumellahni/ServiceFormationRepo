package com.oumellahni.serviceformation.controller;

import com.oumellahni.serviceformation.controller.api.CommandeClientApi;
import com.oumellahni.serviceformation.dto.CommandeClientDto;
import com.oumellahni.serviceformation.service.CommandeClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 2:46 PM - 8/26/2022
 */

@RestController
@AllArgsConstructor
public class CommandeClientController implements CommandeClientApi {

    private CommandeClientService commandeClientService;


    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        return commandeClientService.save(dto);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        return commandeClientService.findCommandeClientById(id);
    }

    @Override
    public CommandeClientDto findCommandeClientByCode(String code) {
        return commandeClientService.findCommandeClientByCode(code);
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        commandeClientService.delete(id);
    }
}
