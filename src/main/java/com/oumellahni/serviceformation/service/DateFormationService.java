package com.oumellahni.serviceformation.service;

import com.oumellahni.serviceformation.dto.DateFormationDto;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 11:05 AM - 8/19/2022
 */

public interface DateFormationService {

    DateFormationDto save(DateFormationDto dto);

    List<DateFormationDto> findAll();

    DateFormationDto findDateFormationById(Integer id);

    void delete (Integer id);
}
