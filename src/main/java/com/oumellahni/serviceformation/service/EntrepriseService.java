package com.oumellahni.serviceformation.service;

import com.oumellahni.serviceformation.dto.EntrepriseDto;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 11:07 AM - 8/19/2022
 */

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto dto);

    List<EntrepriseDto> findAll();

    EntrepriseDto findEntrepriseById(Integer id);

    EntrepriseDto findEntrepriseByNom(String nom);

    void delete(Integer id);
}
