package com.oumellahni.serviceformation.service;

import com.oumellahni.serviceformation.dto.FormateurDto;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 11:12 AM - 8/19/2022
 */

public interface FormateurService {

    FormateurDto save(FormateurDto dto);

    FormateurDto findFormateurById(Integer id);

    FormateurDto findFormateurByNom(String nom);

    FormateurDto findFormateurByPrenom(String prenom);

    FormateurDto findFormateurByNumTel(String numTel);

    List<FormateurDto> findAll();

    void delete(Integer id);
}
