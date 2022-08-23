//package com.oumellahni.serviceformation.controller.api;
//
//import com.oumellahni.serviceformation.dto.CategoryDto;
//import com.oumellahni.serviceformation.model.Formation;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.ArraySchema;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import static com.oumellahni.serviceformation.util.Constant.APP_ROOT;
//
///**
// * @author N.Oumellahni
// * at 9:46 AM - 8/23/2022
// */
//
//@Tag(name = "category", description = "Category API")
//public interface CategoryApi {
//
//    @PostMapping(
//            value = "blabla",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    @Operation(
//            summary = "Enregistrer une categoie",
//            description = "Cette methode permet d'enregistrer ou modifier une categorie",
//            tags = {"category"}
//    )
//    @ApiResponses(value = {
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "La categorie cree / modifie.",
//                    content = @Content(array = @ArraySchema(
//                            schema = @Schema(implementation = Formation.class)))
//            ),
//            @ApiResponse(
//                    responseCode = "400",
//                    description = "La categorie n'est pas valide."
//            )
//    })
//    CategoryDto save(@RequestBody CategoryDto dto);
//
//    @GetMapping(
//            value = APP_ROOT,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    @Operation(
//            summary = "Rechercher une categorie.",
//            description = "Cette methode permet de rechercher une categorie.",
//            tags = { "category" }
//    )
//    @ApiResponses(value = {
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "La categorie a ete trouvee dans la BDD.",
//                    content = @Content(array = @ArraySchema(
//                            schema = @Schema(implementation = Formation.class)))
//            ),
//            @ApiResponse(
//                    responseCode = "404",
//                    description = "Aucune categorie n'existe dans la BDD avec l'ID fourni."
//            )
//    })
//    CategoryDto findById(@PathVariable("id") Integer id);
//
//
//}
