package com.oumellahni.serviceformation.controller.api;

import com.oumellahni.serviceformation.dto.FormationDto;
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
 * at 2:29 PM - 8/22/2022
 */

@Tag(name = "formation", description = "Formation API")
public interface FormationApi {

    @PostMapping(
            value = APP_ROOT + FORMATION + ADD,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Enregistrer une formation.",
            description = "Cette methode permet d'enregistrer ou modifier une formation.",
            tags = { "formation" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La formation cree / modifie.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = FormationDto.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "La formation n'est pas valide."
            )
    })
    FormationDto save(@RequestBody FormationDto dto);

    @GetMapping(
            value = APP_ROOT + FORMATION + FORMATION_PATH_ID,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher une formation.",
            description = "Cette methode permet de rechercher une formation.",
            tags = { "formation" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La formation a ete trouvee dans la BDD.",
                    content = @Content(array = @ArraySchema(
                    schema = @Schema(implementation = FormationDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucune formation n'existe dans la BDD avec l'ID fourni."
            )
    })
    FormationDto findById(@PathVariable(FORMATION_PATH_VARIABLE_ID) Integer id);

    @GetMapping(
            value = APP_ROOT  + FORMATION + FILTER + FORMATION_PATH_CODE, //xi haja hna khasssa
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher une formation par CODE",
            description = "Cette methode permet de chercher une formation par son CODE",
            tags = { "formation" }
             )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La formation a ete trouve dans la BDD",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = FormationDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun formation n'existe dans la BDD avec le CODE fourni"
            )
    })
    FormationDto findFormationByCode(@PathVariable(FORMATION_PATH_VARIABLE_CODE) String code);

    @GetMapping(
            value = APP_ROOT + FORMATION + ALL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Renvoi la liste des formations",
            description = "Cette methode permet de chercher et renvoyer la liste des formations qui existent",
            tags = { "formation" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La liste des formations / Une liste vide",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = FormationDto.class)))
            )
    })
    List<FormationDto> findAll();

    @DeleteMapping(
            value = APP_ROOT  + FORMATION + DELETE + FORMATION_PATH_ID
    )
    @Operation(
            summary = "Supprimer une formation",
            description = "Cette methode permet de supprimer une formation par ID",
            tags = { "formation" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La formation a ete supprime"
            )
    })

    void delete(@PathVariable(FORMATION_PATH_VARIABLE_ID) Integer id);

    //----------------------------------------------------------------
    //TODO : Complete other methods ...
    //----------------------------------------------------------------
}
