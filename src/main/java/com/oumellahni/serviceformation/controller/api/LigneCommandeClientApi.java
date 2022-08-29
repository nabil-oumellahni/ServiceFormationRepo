//package com.oumellahni.serviceformation.controller.api;
//
//import com.oumellahni.serviceformation.dto.FormationDto;
//import com.oumellahni.serviceformation.dto.LigneCommandeClientDto;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.ArraySchema;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//import static com.oumellahni.serviceformation.util.Constant.*;
//
///**
// * @author N.Oumellahni
// * at 10:59 AM - 8/26/2022
// */
//
//@Tag(name = "ligneCommandeClient", description = "Ligne Commande Client API")
//public interface LigneCommandeClientApi {
//
//    @PostMapping(
//            value = APP_ROOT + LIGNE_COMMANDE_CLIENT + ADD,
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    @Operation(
//            summary = "Enregistrer une ligne de commande client.",
//            description = "Cette methode permet d'enregistrer ou modifier une ligne de commande client.",
//            tags = { "ligneCommandeClient" }
//    )
//    @ApiResponses(value = {
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "La ligne de commande client cree / modifie.",
//                    content = @Content(array = @ArraySchema(
//                            schema = @Schema(implementation = LigneCommandeClientApi.class)))
//            ),
//            @ApiResponse(
//                    responseCode = "400",
//                    description = "La ligne de commande client n'est pas valide."
//            )
//    })
//    LigneCommandeClientDto save(@RequestBody LigneCommandeClientDto dto);
//
//    @GetMapping(
//            value = APP_ROOT + LIGNE_COMMANDE_CLIENT + LIGNE_COMMANDE_CLIENT_PATH_ID,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    @Operation(
//            summary = "Rechercher une ligne de commande client",
//            description = "Cette methode permet de rechercher une ligne de commande client",
//            tags = { "ligneCommandeClient" }
//    )
//    @ApiResponses(value = {
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "La ligne de commande client a ete trouvee dans la BDD.",
//                    content = @Content(array = @ArraySchema(
//                            schema = @Schema(implementation = LigneCommandeClientDto.class)))
//            ),
//            @ApiResponse(
//                    responseCode = "404",
//                    description = "Aucune ligne de commande client n'existe dans la BDD avec l'ID fourni."
//            )
//    })
//    LigneCommandeClientDto findById(@PathVariable(LIGNE_COMMANDE_CLIENT_PATH_VARIABLE_ID) Integer id);
//
//    @GetMapping(
//            value = APP_ROOT + LIGNE_COMMANDE_CLIENT + ALL,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    @Operation(
//            summary = "Renvoi la liste des lignes de commande client",
//            description = "Cette methode permet de chercher et renvoyer la liste des lignes de commande client qui existent",
//            tags = { "ligneCommandeClient" }
//    )
//    @ApiResponses(value = {
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "La liste des lignes de commande client / Une liste vide",
//                    content = @Content(array = @ArraySchema(
//                            schema = @Schema(implementation = LigneCommandeClientDto.class)))
//            )
//    })
//    List<LigneCommandeClientDto> findAll();
//
//    @DeleteMapping(
//            value = APP_ROOT  + LIGNE_COMMANDE_CLIENT + DELETE +  LIGNE_COMMANDE_CLIENT_PATH_ID
//    )
//    @Operation(
//            summary = "Supprimer une ligne de commande client",
//            description = "Cette methode permet de supprimer une ligne de commande client par ID",
//            tags = { "ligneCommandeClient" }
//    )
//    @ApiResponses(value = {
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "La ligne de commande client a ete supprime"
//            )
//    })
//
//
//    void delete(@PathVariable(LIGNE_COMMANDE_CLIENT_PATH_VARIABLE_ID) Integer id);
//
//}
