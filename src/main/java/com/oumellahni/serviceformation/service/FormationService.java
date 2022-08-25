package com.oumellahni.serviceformation.service;

import com.oumellahni.serviceformation.dto.FormationDto;
import com.oumellahni.serviceformation.model.Formation;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:41 AM - 8/19/2022
 */

public interface FormationService {

    FormationDto save(FormationDto dto);

    FormationDto findFormationById(Integer id);

    FormationDto findFormationByTitre(String titre);

    FormationDto findFormationByCode(String code);

    List<FormationDto>findAllByCategoryId(Integer idCategory);

    List<FormationDto>findAllByFormateurId(Integer idFormateur);

    List<FormationDto>findAllByDateFormationId(Integer idDateFormation);

    List<FormationDto> findAll();

    void delete(Integer id);

}
