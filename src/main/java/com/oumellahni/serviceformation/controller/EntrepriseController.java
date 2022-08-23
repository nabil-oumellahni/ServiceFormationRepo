package com.oumellahni.serviceformation.controller;

import com.oumellahni.serviceformation.controller.api.EntrepriseApi;
import com.oumellahni.serviceformation.dto.EntrepriseDto;
import com.oumellahni.serviceformation.service.EntrepriseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 3:17 PM - 8/23/2022
 */

@RestController
@AllArgsConstructor
public class EntrepriseController implements EntrepriseApi {

    private EntrepriseService entrepriseService;

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return entrepriseService.save(dto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findEntrepriseById(id);
    }

    @Override
    public EntrepriseDto findEntrepriseByNom(String nom) {
        return entrepriseService.findEntrepriseByNom(nom);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
        entrepriseService.delete(id);
    }
}
