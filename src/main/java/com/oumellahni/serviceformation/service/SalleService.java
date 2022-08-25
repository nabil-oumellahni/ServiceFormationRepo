package com.oumellahni.serviceformation.service;

import com.oumellahni.serviceformation.dto.SalleDto;
import com.oumellahni.serviceformation.model.Salle;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:51 AM - 8/19/2022
 */

public interface SalleService {

    SalleDto save(SalleDto dto);

    SalleDto findSalleById(Integer id);

    SalleDto findSalleByCode(String code);

    List<SalleDto>findAllByFormationId(Integer idFormation);

    List<SalleDto> findAll();

    void delete(Integer id);
}
