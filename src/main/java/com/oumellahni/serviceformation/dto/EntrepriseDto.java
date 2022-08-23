package com.oumellahni.serviceformation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.oumellahni.serviceformation.model.Entreprise;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:52 AM - 8/18/2022
 */
@Data
@Builder
public class EntrepriseDto {

    private Integer id;

    private String nom;

    private String description;

    private AdresseDto adresse;

    private String filiale;

    private String email;

    private String numTel;

    private String siteWeb;

    @JsonIgnore
    private List<ClientDto> clients;

    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
                .filiale(entreprise.getFiliale())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
        if (entrepriseDto == null) {
            return null;
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));
        entreprise.setFiliale(entrepriseDto.getFiliale());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setNumTel(entrepriseDto.getNumTel());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
        return entreprise;
    }
}
