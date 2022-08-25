package com.oumellahni.serviceformation.controller;

import com.oumellahni.serviceformation.controller.api.SalleApi;
import com.oumellahni.serviceformation.dto.SalleDto;
import com.oumellahni.serviceformation.service.SalleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 7:30 PM - 8/24/2022
 */

@RestController
@AllArgsConstructor
public class SalleController implements SalleApi {

    private SalleService salleService;


    @Override
    public SalleDto save(SalleDto dto) {
        return salleService.save(dto);
    }

    @Override
    public SalleDto findById(Integer id) {
        return salleService.findSalleById(id);
    }

    @Override
    public SalleDto findSalleByCode(String code) {
        return salleService.findSalleByCode(code);
    }

    @Override
    public List<SalleDto> findAll() {
        return salleService.findAll();
    }

    @Override
    public List<SalleDto> findAllByFormationId(Integer idFormation) {
        return salleService.findAllByFormationId(idFormation);
    }

    @Override
    public void delete(Integer id) {
        salleService.delete(id);
    }

}
