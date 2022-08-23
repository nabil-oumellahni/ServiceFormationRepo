package com.oumellahni.serviceformation.controller.api;

import com.oumellahni.serviceformation.dto.EntrepriseDto;
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
 * at 2:48 PM - 8/23/2022
 */

@Tag(name = "entreprise", description = "Entreprise API")
public interface EntrepriseApi {

    @PostMapping(
            value = APP_ROOT + ENTREPRISE + ADD,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Enregistrer une entreprise.",
            description = "Cette methode permet d'enregistrer ou modifier une entreprise.",
            tags = { "entreprise" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "L'entreprise cree / modifie.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = EntrepriseDto.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "L'entreprise n'est pas valide."
            )
    })
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @GetMapping(
            value = APP_ROOT + ENTREPRISE + ENTREPRISE_PATH_ID,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher une entreprise par ID.",
            description = "Cette methode permet de rechercher une entreprise par ID.",
            tags = { "entreprise" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "L'entreprise  a ete trouvee dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = EntrepriseDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucune entreprise n'existe dans la BDD avec l'ID fourni."
            )
    })
    EntrepriseDto findById(@PathVariable(ENTREPRISE_PATH_VARIABLE_ID) Integer id);

    @GetMapping(
            value = APP_ROOT + ENTREPRISE + FILTER + ENTREPRISE_PATH_NOM,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher une entreprise par NOM.",
            description = "Cette methode permet de rechercher une entreprise par NOM.",
            tags = { "entreprise" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "L'entreprise  a ete trouvee dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = EntrepriseDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucune entreprise n'existe dans la BDD avec le NOM fourni."
            )
    })
    EntrepriseDto findEntrepriseByNom(@PathVariable(ENTREPRISE_PATH_VARIABLE_NOM) String nom);

    @GetMapping(
            value = APP_ROOT + ENTREPRISE + ALL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Renvoi la liste des entreprises",
            description = "Cette methode permet de chercher et renvoyer la liste des entreprises qui existent",
            tags = { "entreprise" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La liste des entreprises / Une liste vide",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = EntrepriseDto.class)))
            )
    })
    List<EntrepriseDto> findAll();

    @DeleteMapping(
            value = APP_ROOT  + ENTREPRISE + DELETE + ENTREPRISE_PATH_ID
    )
    @Operation(
            summary = "Supprimer une entreprise",
            description = "Cette methode permet de supprimer une entreprise par ID",
            tags = { "entreprise" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "L'entreprise a ete supprime"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "L'entreprise que vous voulez supprimer n'existe pas"
            )
    })
    void delete(@PathVariable(ENTREPRISE_PATH_VARIABLE_ID) Integer id);
}
