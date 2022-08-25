package com.oumellahni.serviceformation.controller;

import com.oumellahni.serviceformation.controller.api.DateFormationApi;
import com.oumellahni.serviceformation.dto.DateFormationDto;
import com.oumellahni.serviceformation.service.DateFormationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 11:32 AM - 8/24/2022
 */

@RestController
@AllArgsConstructor
public class DateFormationController implements DateFormationApi {

    private DateFormationService dateFormationService;

    @Override
    public DateFormationDto save(DateFormationDto dto) {
        return dateFormationService.save(dto);
    }

    @Override
    public DateFormationDto findById(Integer id) {
        return dateFormationService.findDateFormationById(id);
    }

    @Override
    public List<DateFormationDto> findAll() {
        return dateFormationService.findAll();
    }

    @Override
    public void delete(Integer id) {
        dateFormationService.delete(id);
    }
}
