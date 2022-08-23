package com.oumellahni.serviceformation.dto;

import com.oumellahni.serviceformation.model.Salle;
import lombok.Builder;
import lombok.Data;

/**
 * @author N.Oumellahni
 * at 10:59 AM - 8/18/2022
 */

@Data
@Builder
public class SalleDto {

    private Integer id;

    private String code;

    private FormationDto formation;

    public static SalleDto fromEntity(Salle salle) {
        if (salle == null) {
            return null;
        }
        return SalleDto.builder()
                .id(salle.getId())
                .code(salle.getCode())
                .formation(FormationDto.fromEntity(salle.getFormation()))
                .build();
    }

    public static Salle toEntity(SalleDto salleDto) {
        if (salleDto == null) {
            return null;
        }
        Salle salle = new Salle();
        salle.setId(salleDto.getId());
        salle.setCode(salleDto.getCode());
        salle.setFormation(FormationDto.toEntity(salleDto.getFormation()));
        return salle;
    }

}
