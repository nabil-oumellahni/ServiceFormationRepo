package com.oumellahni.serviceformation.controller.api;

import com.oumellahni.serviceformation.dto.DateFormationDto;
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
 * at 11:16 AM - 8/24/2022
 */

@Tag(name = "dateFormation", description = "DateFormation API")
public interface DateFormationApi {

    @PostMapping(
            value = APP_ROOT + DATE_FORMATION + ADD,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Enregistrer une date formation",
            description = "Cette methode permet d'enregistrer ou modifier une date formation",
            tags = {"dateFormation"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La date formation cree / modifie.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = DateFormationDto.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "La date formation n'est pas valide."
            )
    })
    DateFormationDto save(@RequestBody DateFormationDto dto);

    @GetMapping(
            value = APP_ROOT + DATE_FORMATION + DATE_FORMATION_PATH_ID,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher une date formation.",
            description = "Cette methode permet de rechercher une date formation.",
            tags = { "dateFormation" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "la date formation a ete trouve dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = DateFormationDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun date formation n'existe dans la BDD avec l'ID fourni."
            )
    })
    DateFormationDto findById(@PathVariable(DATE_FORMATION_PATH_VARIABLE_ID) Integer id);

    @GetMapping(
            value = APP_ROOT + DATE_FORMATION + ALL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Renvoi la liste des dates formation",
            description = "Cette methode permet de chercher et renvoyer la liste des dates formation qui existent",
            tags = { "dateFormation" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La liste des dates formation / Une liste vide",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = DateFormationDto.class)))
            )
    })
    List<DateFormationDto> findAll();

    @DeleteMapping(
            value = APP_ROOT  + DATE_FORMATION + DELETE + DATE_FORMATION_PATH_ID
    )
    @Operation(
            summary = "Supprimer une date formation",
            description = "Cette methode permet de supprimer une date formation par ID",
            tags = { "dateFormation" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La dateFormation a ete supprime"
            )
    })
    void delete(@PathVariable(DATE_FORMATION_PATH_VARIABLE_ID) Integer id);
}
