package com.oumellahni.serviceformation.dto;

import com.oumellahni.serviceformation.model.Niveau;
import lombok.Builder;
import lombok.Data;

/**
 * @author N.Oumellahni
 * at 10:58 AM - 8/18/2022
 */

@Data
@Builder
public class NiveauDto {

    private Integer id;

    private String titre;

    private FormationDto formation;

    public static NiveauDto fromEntity(Niveau niveau) {
        if (niveau ==  null) {
            return null;
        }
        return NiveauDto.builder()
                .id(niveau.getId())
                .titre(niveau.getTitre())
                .formation(FormationDto.fromEntity(niveau.getFormation()))
                .build();
    }

    public static Niveau toEntity(NiveauDto niveauDto) {
        if (niveauDto == null) {
            return null;
        }
        Niveau niveau = new Niveau();
        niveau.setId(niveauDto.getId());
        niveau.setTitre(niveauDto.getTitre());
        niveau.setFormation(FormationDto.toEntity(niveauDto.getFormation()));
        return niveau;
    }
}
