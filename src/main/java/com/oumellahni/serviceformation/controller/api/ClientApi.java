package com.oumellahni.serviceformation.controller.api;

import com.oumellahni.serviceformation.dto.ClientDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.oumellahni.serviceformation.util.Constant.*;

/**
 * @author N.Oumellahni
 * at 3:53 PM - 8/23/2022
 */

@Tag(name = "client", description = "Client API")
public interface ClientApi {

    @PostMapping(
            value = APP_ROOT + CLIENT + ADD,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Enregistrer un client",
            description = "Cette methode permet d'enregistrer ou modifier un client",
            tags = {"client"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le client cree / modifie.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = ClientDto.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Le client n'est pas valide."
            )
    })
    ClientDto save(@RequestBody ClientDto dto);

    @GetMapping(
            value = APP_ROOT + CLIENT + CLIENT_PATH_ID,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un client.",
            description = "Cette methode permet de rechercher un client.",
            tags = { "client" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le client a ete trouve dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = ClientDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun client n'existe dans la BDD avec l'ID fourni."
            )
    })
    ClientDto findById(@PathVariable(CLIENT_PATH_VARIABLE_ID) Integer id);

    @GetMapping(
            value = APP_ROOT + CLIENT + FILTER + BY_NOM +  CLIENT_PATH_NOM,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un client par NOM.",
            description = "Cette methode permet de rechercher un client par NOM.",
            tags = { "client" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le client a ete trouve dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = ClientDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun client n'existe dans la BDD avec le NOM fourni."
            )
    })
    ClientDto findClientByNom(@PathVariable(CLIENT_PATH_VARIABLE_NOM) String nom);

    @GetMapping(
            value = APP_ROOT + CLIENT + FILTER + BY_PRENOM + CLIENT_PATH_PRENOM,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un client par PRENOM.",
            description = "Cette methode permet de rechercher un client par PRENOM.",
            tags = { "client" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le client a ete trouve dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = ClientDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun client n'existe dans la BDD avec le PRENOM fourni."
            )
    })
    ClientDto findClientByPrenom(@PathVariable(CLIENT_PATH_VARIABLE_PRENOM) String prenom);

    @GetMapping(
            value = APP_ROOT + CLIENT + FILTER + BY_NUM_TEL + CLIENT_PATH_NUM_TEL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un client par NUM_TEL.",
            description = "Cette methode permet de rechercher un client par NUM_TEL.",
            tags = { "client" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le client a ete trouve dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = ClientDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun client n'existe dans la BDD avec le NUM_TEL fourni."
            )
    })
    ClientDto findClientByNumTel(@PathVariable(CLIENT_PATH_VARIABLE_NUM_TEL) String numTel);

    @GetMapping(
            value = APP_ROOT + CLIENT + ALL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Renvoi la liste des clients",
            description = "Cette methode permet de chercher et renvoyer la liste des clients qui existent",
            tags = { "client" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La liste des clients / Une liste vide",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = ClientDto.class)))
            )
    })
    List<ClientDto> findAll();

    @GetMapping(
            value = APP_ROOT + CLIENT + FILTER + ALL + BY_ENTREPRISE_ID,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Renvoi la liste des clients par leur ID de l'entreprise",
            description = "Cette methode permet de chercher et renvoyer la liste des clients par leur ID de l'entreprise qui existent",
            tags = { "client" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La liste des clients / Une liste vide par leur ID de l'entreprise",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = ClientDto.class)))
            )
    })
    List<ClientDto> findAllByEntrepriseId(Integer idEntreprise);

    @DeleteMapping(
            value = APP_ROOT  + CLIENT + DELETE + CLIENT_PATH_ID
    )
    @Operation(
            summary = "Supprimer un client",
            description = "Cette methode permet de supprimer un client par ID",
            tags = { "client" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le client a ete supprime"
            )
    })
    void delete(@PathVariable(CLIENT_PATH_VARIABLE_ID) Integer id);
}
