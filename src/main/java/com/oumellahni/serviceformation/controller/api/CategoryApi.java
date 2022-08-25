package com.oumellahni.serviceformation.controller.api;

import com.oumellahni.serviceformation.dto.CategoryDto;
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
 * at 9:46 AM - 8/23/2022
 */

@Tag(name = "category", description = "Category API")
public interface CategoryApi {

    @PostMapping(
            value = APP_ROOT + CATEGORY + ADD,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Enregistrer une categorie",
            description = "Cette methode permet d'enregistrer ou modifier une categorie",
            tags = {"category"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La categorie cree / modifie.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = ClientDto.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "La categorie n'est pas valide."
            )
    })
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(
            value = APP_ROOT + CATEGORY + CATEGORY_PATH_ID,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher une categorie",
            description = "Cette methode permet de rechercher une categorie",
            tags = { "category" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La categorie a ete trouvee dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = CategoryDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucune categorie n'existe dans la BDD avec l'ID fourni."
            )
    })
    CategoryDto findById(@PathVariable(CATEGORY_PATH_VARIABLE_ID) Integer id);

    @GetMapping(
            value = APP_ROOT  + CATEGORY + FILTER + BY_CODE + CATEGORY_PATH_CODE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher une categorie par CODE",
            description = "Cette methode permet de chercher une categorie par son CODE",
            tags = { "category" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La categorie a ete trouve dans la BDD",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = CategoryDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun categorie n'existe dans la BDD avec le CODE fourni"
            )
    })
    CategoryDto findCategoryByCode(@PathVariable(CATEGORY_PATH_VARIABLE_CODE) String code);

    @GetMapping(
            value = APP_ROOT  + CATEGORY + FILTER + BY_TITRE+CATEGORY_PATH_TITRE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher une categorie par TITRE",
            description = "Cette methode permet de chercher une categorie par son TITRE",
            tags = { "category" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La categorie a ete trouve dans la BDD",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = CategoryDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun categorie n'existe dans la BDD avec le TITRE fourni"
            )
    })
    CategoryDto findCategoryByTitre(@PathVariable(CATEGORY_PATH_VARIABLE_TITRE) String titre);

    @GetMapping(
            value = APP_ROOT + CATEGORY + ALL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Renvoi la liste des categories",
            description = "Cette methode permet de chercher et renvoyer la liste des categories qui existent",
            tags = { "category" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La liste des categories / Une liste vide",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = CategoryDto.class)))
            )
    })
    List<CategoryDto> findAll();

    @DeleteMapping(
            value = APP_ROOT  + CATEGORY + DELETE + CATEGORY_PATH_ID
    )
    @Operation(
            summary = "Supprimer une categorie",
            description = "Cette methode permet de supprimer une categorie par ID",
            tags = { "category" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La categorie a ete supprime"
            )
    })
    void delete(@PathVariable(CATEGORY_PATH_VARIABLE_ID) Integer id);
}
