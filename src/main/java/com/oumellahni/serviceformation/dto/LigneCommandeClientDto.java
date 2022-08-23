package com.oumellahni.serviceformation.dto;

import com.oumellahni.serviceformation.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

/**
 * @author N.Oumellahni
 * at 10:56 AM - 8/18/2022
 */

@Data
@Builder
public class LigneCommandeClientDto {

    private Integer id;

    private BigDecimal prixUnitaire;

    private CommandeClientDto commandeClient;

    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient) {
        if (ligneCommandeClient == null) {
            return null;
        }
        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .commandeClient(CommandeClientDto.fromEntity(ligneCommandeClient.getCommandeClient()))
                .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto) {
        if (ligneCommandeClientDto == null) {
            return null;
        }
        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
        ligneCommandeClient.setCommandeClient(CommandeClientDto.toEntity(ligneCommandeClientDto.getCommandeClient()));
        return ligneCommandeClient;
    }
}
