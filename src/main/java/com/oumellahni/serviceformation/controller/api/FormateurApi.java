package com.oumellahni.serviceformation.controller.api;

import com.oumellahni.serviceformation.dto.FormateurDto;
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
 * at 10:48 AM - 8/24/2022
 */

@Tag(name = "formateur", description = "Formateur API")
public interface FormateurApi {

    @PostMapping(
            value = APP_ROOT + FORMATEUR + ADD,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Enregistrer un formateur",
            description = "Cette methode permet d'enregistrer ou modifier un formateur",
            tags = {"formateur"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le formateur cree / modifie.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = FormateurDto.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Le formateur n'est pas valide."
            )
    })
    FormateurDto save(@RequestBody FormateurDto dto);

    @GetMapping(
            value = APP_ROOT + FORMATEUR + FORMATEUR_PATH_ID,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un formateur.",
            description = "Cette methode permet de rechercher un formateur.",
            tags = { "formateur" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le formateur a ete trouve dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = FormateurDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun formateur n'existe dans la BDD avec l'ID fourni."
            )
    })
    FormateurDto findById(@PathVariable(FORMATEUR_PATH_VARIABLE_ID) Integer id);

    @GetMapping(
            value = APP_ROOT + FORMATEUR + FILTER + BY_NOM +  FORMATEUR_PATH_NOM,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un formateur par NOM.",
            description = "Cette methode permet de rechercher un formateur par NOM.",
            tags = { "formateur" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le formateur a ete trouve dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = FormateurDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun formateur n'existe dans la BDD avec le NOM fourni."
            )
    })
    FormateurDto findFormateurByNom(@PathVariable(FORMATEUR_PATH_VARIABLE_NOM) String nom);

    @GetMapping(
            value = APP_ROOT + FORMATEUR + FILTER + BY_PRENOM + FORMATEUR_PATH_PRENOM,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un formateur par PRENOM.",
            description = "Cette methode permet de rechercher un formateur par PRENOM.",
            tags = { "formateur" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le formateur a ete trouve dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = FormateurDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun formateur n'existe dans la BDD avec le PRENOM fourni."
            )
    })
    FormateurDto findFormateurByPrenom(@PathVariable(FORMATEUR_PATH_VARIABLE_PRENOM) String prenom);

    @GetMapping(
            value = APP_ROOT + FORMATEUR + FILTER + BY_NUM_TEL + FORMATEUR_PATH_NUM_TEL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un formateur par NUM_TEL.",
            description = "Cette methode permet de rechercher un formateur par NUM_TEL.",
            tags = { "formateur" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le formateur a ete trouve dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = FormateurDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun Formateur n'existe dans la BDD avec le NUM_TEL fourni."
            )
    })
    FormateurDto findFormateurByNumTel(@PathVariable(FORMATEUR_PATH_VARIABLE_NUM_TEL) String numTel);

    @GetMapping(
            value = APP_ROOT + FORMATEUR + ALL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Renvoi la liste des formateurs",
            description = "Cette methode permet de chercher et renvoyer la liste des formateurs qui existent",
            tags = { "formateur" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La liste des formateurs / Une liste vide",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = FormateurDto.class)))
            )
    })
    List<FormateurDto> findAll();

    @DeleteMapping(
            value = APP_ROOT  + FORMATEUR + DELETE + FORMATEUR_PATH_ID
    )
    @Operation(
            summary = "Supprimer un formateur",
            description = "Cette methode permet de supprimer un formateur par ID",
            tags = { "formateur" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le formateur a ete supprime"
            )
    })
    void delete(@PathVariable(FORMATEUR_PATH_VARIABLE_ID) Integer id);

}
