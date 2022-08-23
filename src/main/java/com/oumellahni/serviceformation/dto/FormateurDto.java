package com.oumellahni.serviceformation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oumellahni.serviceformation.model.Formateur;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:54 AM - 8/18/2022
 */

@Data
@Builder
public class FormateurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String email;

    private String numTel;

    @JsonIgnore
    private List<FormationDto> formations;

    public static FormateurDto fromEntity(Formateur formateur) {
        if (formateur == null) {
            return null;
        }
        return FormateurDto.builder()
                .id(formateur.getId())
                .nom(formateur.getNom())
                .prenom(formateur.getPrenom())
                .adresse(AdresseDto.fromEntity(formateur.getAdresse()))
                .photo(formateur.getPhoto())
                .email(formateur.getEmail())
                .numTel(formateur.getNumTel())
                .build();
    }

    public static Formateur toEntity(FormateurDto formateurDto) {
        if (formateurDto == null) {
            return null;
        }
        Formateur formateur = new Formateur();
        formateur.setId(formateurDto.getId());
        formateur.setNom(formateurDto.getNom());
        formateur.setPrenom(formateurDto.getPrenom());
        formateur.setAdresse(AdresseDto.toEntity(formateurDto.getAdresse()));
        formateur.setPhoto(formateurDto.getPhoto());
        formateur.setEmail(formateurDto.getEmail());
        formateur.setNumTel(formateurDto.getNumTel());
        return formateur;
    }
}
