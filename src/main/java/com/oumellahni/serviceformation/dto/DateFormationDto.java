package com.oumellahni.serviceformation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oumellahni.serviceformation.model.DateFormation;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:43 AM - 8/18/2022
 */

@Data
@Builder
public class DateFormationDto {

    private Integer id;

    private Date date;

    @JsonIgnore
    private List<FormationDto> formations;

    public static DateFormationDto fromEntity(DateFormation dateFormation) {
        if (dateFormation == null) {
            return null;
        }
        return DateFormationDto.builder()
                .id(dateFormation.getId())
                .date(dateFormation.getDate())
                .build();
    }

    public static DateFormation toEntity(DateFormationDto dateFormationDto) {
        if (dateFormationDto == null) {
            return null;
        }
        DateFormation dateFormation = new DateFormation();
        dateFormation.setId(dateFormationDto.getId());
        dateFormation.setDate(dateFormationDto.getDate());
        return dateFormation;
    }
}
