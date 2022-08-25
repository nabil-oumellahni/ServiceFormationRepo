package com.oumellahni.serviceformation.controller;

import com.oumellahni.serviceformation.controller.api.FormationApi;
import com.oumellahni.serviceformation.dto.FormationDto;
import com.oumellahni.serviceformation.service.FormationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 2:29 PM - 8/22/2022
 */

@RestController
@AllArgsConstructor
public class FormationController implements FormationApi {

    private FormationService formationService;

    @Override
    public FormationDto save(FormationDto dto) {
        return formationService.save(dto);
    }

    @Override
    public FormationDto findById(Integer id) {
        return formationService.findFormationById(id);
    }

    @Override
    public FormationDto findFormationByTitre(String titre) {
        return formationService.findFormationByTitre(titre);
    }

    @Override
    public FormationDto findFormationByCode(String code) {
        return formationService.findFormationByCode(code);
    }

    @Override
    public List<FormationDto> findAll() {
        return formationService.findAll();
    }

    @Override
    public List<FormationDto> findAllByCategoryId(Integer idCategory) {
        return formationService.findAllByCategoryId(idCategory);
    }

    @Override
    public List<FormationDto> findAllByFormateurId(Integer idFormateur) {
        return formationService.findAllByFormateurId(idFormateur);
    }

    @Override
    public List<FormationDto> findAllByDateFormationId(Integer idDateFormation) {
        return formationService.findAllByDateFormationId(idDateFormation);
    }

    @Override
    public void delete(Integer id) {
        formationService.delete(id);
    }

    //----------------------------------------------------------------
    //TODO : implement other methods ...
    //----------------------------------------------------------------
}
