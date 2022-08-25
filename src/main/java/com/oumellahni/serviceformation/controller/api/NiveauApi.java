package com.oumellahni.serviceformation.controller.api;

import com.oumellahni.serviceformation.dto.CategoryDto;
import com.oumellahni.serviceformation.dto.ClientDto;
import com.oumellahni.serviceformation.dto.NiveauDto;
import com.oumellahni.serviceformation.service.NiveauService;
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
 * at 3:44 PM - 8/24/2022
 */

@Tag(name = "niveau", description = "Niveau API")
public interface NiveauApi {

    @PostMapping(
            value = APP_ROOT + NIVEAU + ADD,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Enregistrer un niveau",
            description = "Cette methode permet d'enregistrer ou modifier un niveau",
            tags = {"niveau"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le niveau cree / modifie.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = NiveauDto.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Le niveau n'est pas valide."
            )
    })
    NiveauDto save(@RequestBody NiveauDto dto);

    @GetMapping(
            value = APP_ROOT + NIVEAU + NIVEAU_PATH_ID,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un niveau par ID.",
            description = "Cette methode permet de rechercher un niveau par ID",
            tags = { "niveau" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le niveau a ete trouvee dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = NiveauDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun niveau n'existe dans la BDD avec l'ID fourni."
            )
    })
    NiveauDto findById(@PathVariable(NIVEAU_PATH_VARIABLE_ID) Integer id);

    @GetMapping(
            value = APP_ROOT  + NIVEAU + FILTER + BY_TITRE+ NIVEAU_PATH_TITRE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un niveau par TITRE",
            description = "Cette methode permet de chercher un niveau par son TITRE",
            tags = { "niveau" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "le niveau a ete trouve dans la BDD",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = NiveauDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun niveau n'existe dans la BDD avec le TITRE fourni"
            )
    })
    NiveauDto findNiveauByTitre(@PathVariable(NIVEAU_PATH_VARIABLE_TITRE) String titre);

    @GetMapping(
            value = APP_ROOT + NIVEAU + ALL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Renvoi la liste des niveaux",
            description = "Cette methode permet de chercher et renvoyer la liste des niveaux qui existent",
            tags = { "niveau" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La liste des niveaux / Une liste vide",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = NiveauDto.class)))
            )
    })
    List<NiveauDto> findAll();

    @DeleteMapping(
            value = APP_ROOT  + NIVEAU + DELETE + NIVEAU_PATH_ID
    )
    @Operation(
            summary = "Supprimer une niveau",
            description = "Cette methode permet de supprimer  niveau par ID",
            tags = { "niveau" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le niveau a ete supprime"
            )
    })
    void delete(@PathVariable(NIVEAU_PATH_VARIABLE_ID) Integer id);



}
