package com.oumellahni.serviceformation.dto;

import com.oumellahni.serviceformation.model.Adresse;
import lombok.Builder;
import lombok.Data;

/**
 * @author N.Oumellahni
 * at 10:51 AM - 8/18/2022
 */

@Data
@Builder
public class AdresseDto {

    private String adresse;

    private String ville;

    private String pays;

    public static AdresseDto fromEntity(Adresse adresse) {
        if (adresse == null) {
            return null;
        }

        return AdresseDto.builder()
                .adresse(adresse.getAdresse())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();
    }

    public static Adresse toEntity(AdresseDto adresseDto) {
        if (adresseDto == null) {
            return null;
        }
        Adresse adresse = new Adresse();
        adresse.setAdresse(adresseDto.getAdresse());
        adresse.setVille(adresseDto.getVille());
        adresse.setPays(adresseDto.getPays());
        return adresse;
    }

}
