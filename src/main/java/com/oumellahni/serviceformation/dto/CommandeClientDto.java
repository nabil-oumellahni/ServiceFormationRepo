package com.oumellahni.serviceformation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oumellahni.serviceformation.model.CommandeClient;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:41 AM - 8/18/2022
 */
@Data
@Builder
public class CommandeClientDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private ClientDto client;

    @JsonIgnore
    private List<LigneCommandeClientDto> ligneCommandes;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .build();

    }

    public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
        if (commandeClientDto == null) {
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClient()));
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());
        return commandeClient;
    }

//    public boolean isCommandeLivree() {
//        return EtatCommande.LIVREE.equals(this.etatCommande);
//    }

    //                .etatCommande(commandeClient.getEtatCommande())
}
