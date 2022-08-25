package com.oumellahni.serviceformation.service;

import com.oumellahni.serviceformation.dto.NiveauDto;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:54 AM - 8/19/2022
 */

public interface NiveauService {

    NiveauDto save(NiveauDto dto);

    NiveauDto findNiveauById(Integer id);

    NiveauDto findNiveauByTitre(String titre);

    List<NiveauDto> findAll();

    void delete(Integer id);

}
