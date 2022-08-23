package com.oumellahni.serviceformation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oumellahni.serviceformation.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:39 AM - 8/18/2022
 */

@Data
@Builder
public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String email;

    private String numTel;

    private EntrepriseDto entreprise;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity(Client client) {
        if (client == null) {
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(AdresseDto.fromEntity(client.getAdresse()))
                .photo(client.getPhoto())
                .email(client.getEmail())
                .numTel(client.getNumTel())
                .entreprise(EntrepriseDto.fromEntity(client.getEntreprise()))
                .build();
    }

    public static Client toEntity(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        }
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setAdresse(AdresseDto.toEntity(clientDto.getAdresse()));
        client.setPhoto(clientDto.getPhoto());
        client.setEmail(clientDto.getEmail());
        client.setNumTel(clientDto.getNumTel());
        client.setEntreprise(EntrepriseDto.toEntity(clientDto.getEntreprise()));
        return client;
    }
}
