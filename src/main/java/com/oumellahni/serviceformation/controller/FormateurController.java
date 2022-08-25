package com.oumellahni.serviceformation.controller;

import com.oumellahni.serviceformation.controller.api.FormateurApi;
import com.oumellahni.serviceformation.dto.FormateurDto;
import com.oumellahni.serviceformation.service.FormateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 11:08 AM - 8/24/2022
 */

@RestController
@AllArgsConstructor
public class FormateurController implements FormateurApi {

    private FormateurService formateurService;


    @Override
    public FormateurDto save(FormateurDto dto) {
        return formateurService.save(dto);
    }

    @Override
    public FormateurDto findById(Integer id) {
        return formateurService.findFormateurById(id);
    }

    @Override
    public FormateurDto findFormateurByNom(String nom) {
        return formateurService.findFormateurByNom(nom);
    }

    @Override
    public FormateurDto findFormateurByPrenom(String prenom) {
        return formateurService.findFormateurByPrenom(prenom);
    }

    @Override
    public FormateurDto findFormateurByNumTel(String numTel) {
        return formateurService.findFormateurByNumTel(numTel);
    }

    @Override
    public List<FormateurDto> findAll() {
        return formateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        formateurService.delete(id);
    }
}
