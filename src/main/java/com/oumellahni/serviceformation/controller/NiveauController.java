package com.oumellahni.serviceformation.controller;

import com.oumellahni.serviceformation.controller.api.NiveauApi;
import com.oumellahni.serviceformation.dto.NiveauDto;
import com.oumellahni.serviceformation.service.NiveauService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 4:03 PM - 8/24/2022
 */

@RestController
@AllArgsConstructor

public class NiveauController implements NiveauApi {

    private NiveauService niveauService;


    @Override
    public NiveauDto save(NiveauDto dto) {
        return niveauService.save(dto);
    }

    @Override
    public NiveauDto findById(Integer id) {
        return niveauService.findNiveauById(id);
    }

    @Override
    public NiveauDto findNiveauByTitre(String titre) {
        return niveauService.findNiveauByTitre(titre);
    }

    @Override
    public List<NiveauDto> findAll() {
        return niveauService.findAll();
    }

    @Override
    public void delete(Integer id) {
        niveauService.delete(id);
    }
}
