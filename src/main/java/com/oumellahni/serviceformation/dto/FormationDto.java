package com.oumellahni.serviceformation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oumellahni.serviceformation.model.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:32 AM - 8/18/2022
 */

@Data
@Builder
public class FormationDto {

    private Integer id;

    private String code;

    private String titre;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String photo;

    private CategoryDto category;

    @JsonIgnore
    private List<SalleDto> salles;

    @JsonIgnore
    private List<NiveauDto> niveaux;

    private FormateurDto formateur;

    private DateFormationDto dateFormation;

    @JsonIgnore
    private List<LigneCommandeClient> ligneCommandeClients;

    public static FormationDto fromEntity(Formation formation) {
        if (formation == null) {
            return null;
        }
        return FormationDto.builder()
                .id(formation.getId())
                .titre(formation.getTitre())
                .code(formation.getCode())
                .designation(formation.getDesignation())
                .prixUnitaireHt(formation.getPrixUnitaireHt())
                .tauxTva(formation.getTauxTva())
                .prixUnitaireTtc(formation.getPrixUnitaireTtc())
                .photo(formation.getPhoto())
                .category(CategoryDto.fromEntity(formation.getCategory()))
                .formateur(FormateurDto.fromEntity(formation.getFormateur()))
                .dateFormation(DateFormationDto.fromEntity(formation.getDateFormation()))
                .build();
    }

    public static Formation toEntity(FormationDto formationDto) {
        if (formationDto == null) {
            return null;
        }
        Formation formation = new Formation();
        formation.setId(formationDto.getId());
        formation.setCode(formationDto.getCode());
        formation.setTitre(formationDto.getTitre());
        formation.setDesignation(formationDto.getDesignation());
        formation.setPrixUnitaireHt(formationDto.getPrixUnitaireHt());
        formation.setTauxTva(formationDto.getTauxTva());
        formation.setPrixUnitaireTtc(formationDto.getPrixUnitaireTtc());
        formation.setPhoto(formationDto.getPhoto());
        formation.setCategory(CategoryDto.toEntity(formationDto.getCategory()));
        formation.setFormateur(FormateurDto.toEntity(formationDto.getFormateur()));
        formation.setDateFormation(DateFormationDto.toEntity(formationDto.getDateFormation()));
        return formation;
    }
}
