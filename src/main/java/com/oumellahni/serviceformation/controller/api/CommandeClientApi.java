package com.oumellahni.serviceformation.controller.api;

import com.oumellahni.serviceformation.dto.CommandeClientDto;
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
 * at 9:38 PM - 8/24/2022
 */

@Tag(name = "CommandeClient", description = "Commende Client API")
public interface CommandeClientApi {

    @PostMapping(
            value = APP_ROOT + COMMANDE_CLIENT + ADD,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Enregistrer une commande client",
            description = "Cette methode permet d'enregistrer ou modifier une commande client",
            tags = {"commandeClient"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La commande client cree / modifie.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = CommandeClientDto.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Le commande client n'est pas valide."
            )
    })
    CommandeClientDto save(@RequestBody CommandeClientDto dto);

    @GetMapping(
            value = APP_ROOT + COMMANDE_CLIENT + COMMANDE_CLIENT_PATH_ID,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher une commande client",
            description = "Cette methode permet de rechercher une commande client",
            tags = { "commandeClient" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La commande client a ete trouvee dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = CommandeClientDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucune commande client n'existe dans la BDD avec l'ID fourni."
            )
    })
    CommandeClientDto findById(@PathVariable(COMMANDE_CLIENT_PATH_VARIABLE_ID) Integer id);


    @GetMapping(
            value = APP_ROOT + COMMANDE_CLIENT + FILTER + COMMANDE_CLIENT_PATH_CODE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher une commande client par CODE",
            description = "Cette methode permet de rechercher une commande client par CODE",
            tags = { "commandeClient" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La commande client a ete trouvee dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = CommandeClientDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucune commande client n'existe dans la BDD avec l'ID fourni."
            )
    })
    CommandeClientDto findCommandeClientByCode(@PathVariable(COMMANDE_CLIENT_PATH_VARIABLE_CODE) String code);

    @GetMapping(
            value = APP_ROOT + COMMANDE_CLIENT + ALL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Renvoi la liste des commandes clients",
            description = "Cette methode permet de chercher et renvoyer la liste des commandes clients qui existent",
            tags = { "CommandeClient" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La liste des commandes clients / Une liste vide",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = CommandeClientDto.class)))
            )
    })
    List<CommandeClientDto> findAll();

    @DeleteMapping(
            value = APP_ROOT  + COMMANDE_CLIENT + DELETE + COMMANDE_CLIENT_PATH_ID
    )
    @Operation(
            summary = "Supprimer une commande client",
            description = "Cette methode permet de supprimer une commande client par ID",
            tags = { "commandeClient" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La commande client a ete supprime"
            )
    })
    void delete(@PathVariable(COMMANDE_CLIENT_PATH_VARIABLE_ID) Integer id);

}
