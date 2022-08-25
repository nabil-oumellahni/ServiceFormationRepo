package com.oumellahni.serviceformation.controller.api;

import com.oumellahni.serviceformation.dto.CategoryDto;
import com.oumellahni.serviceformation.dto.SalleDto;
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
 * at 4:13 PM - 8/24/2022
 */

@Tag(name = "salle", description = "Salle API")
public interface SalleApi {

    @PostMapping(
            value = APP_ROOT + SALLE + ADD,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Enregistrer une salle",
            description = "Cette methode permet d'enregistrer ou modifier une salle",
            tags = {"salle"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La salle cree / modifie.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = SalleDto.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "La salle n'est pas valide."
            )
    })
    SalleDto save(@RequestBody SalleDto dto);

    @GetMapping(
            value = APP_ROOT + SALLE + SALLE_PATH_ID,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher une salle par ID.",
            description = "Cette methode permet de rechercher une salle par ID",
            tags = { "salle" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La salle a ete trouvee dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = SalleDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucune salle n'existe dans la BDD avec l'ID fourni."
            )
    })
    SalleDto findById(@PathVariable(SALLE_PATH_VARIABLE_ID) Integer id);

    @GetMapping(
            value = APP_ROOT  + SALLE + FILTER + BY_CODE + SALLE_PATH_CODE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher une salle par CODE",
            description = "Cette methode permet de chercher une salle par son CODE",
            tags = { "salle" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La salle a ete trouve dans la BDD",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = SalleDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucune salle n'existe dans la BDD avec le CODE fourni"
            )
    })
    SalleDto findSalleByCode(@PathVariable(SALLE_PATH_VARIABLE_CODE) String code);

    @GetMapping(
            value = APP_ROOT + SALLE + ALL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Renvoi la liste des salles",
            description = "Cette methode permet de chercher et renvoyer la liste des salles qui existent",
            tags = { "salle" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La liste des salles / Une liste vide",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = SalleDto.class)))
            )
    })
    List<SalleDto> findAll();

    @GetMapping(
            value = APP_ROOT + SALLE + FILTER + ALL + BY_FORMATION_ID,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Renvoi la liste des salles par leur ID de formation ",
            description = "Cette methode permet de chercher et renvoyer la liste des salles par leur ID de formation qui existent",
            tags = { "salle" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La liste des salles / Une liste vide par leur ID de formation",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = SalleDto.class)))
            )
    })
    List<SalleDto> findAllByFormationId(Integer idFormation);

    @DeleteMapping(
            value = APP_ROOT  + SALLE + DELETE + SALLE_PATH_ID
    )
    @Operation(
            summary = "Supprimer une salle",
            description = "Cette methode permet de supprimer une salle par ID",
            tags = { "salle" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La salle a ete supprime"
            )
    })
    void delete(@PathVariable(SALLE_PATH_VARIABLE_ID) Integer id);


}
