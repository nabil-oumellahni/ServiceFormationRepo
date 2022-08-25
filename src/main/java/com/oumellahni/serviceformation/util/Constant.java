package com.oumellahni.serviceformation.util;

/**
 * @author N.Oumellahni
 * at 4:05 PM - 8/22/2022
 */

public class Constant {

    public static final String APP_ROOT = "service-formation/api";

    public static final String ADD = "/add";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    public static final String ALL = "/all";
    public static final String FILTER = "/filter";
    public static final String  BY_CODE = "/by_code";
    public static final String BY_TITRE = "/by_titre";
    public static final String BY_NOM = "/by_nom";
    public static final String BY_PRENOM = "/by_prenom";
    public static final String BY_NUM_TEL = "/by_num_tel";

    public static final String AUTHENTICATE=APP_ROOT+"/authenticate";

    public static final String FORMATION="/formations";
    public static final String FORMATION_PATH_VARIABLE_ID ="id";
    public static final String FORMATION_PATH_VARIABLE_CODE ="code";
    public static final String FORMATION_PATH_VARIABLE_TITRE ="titre";
    public static final String FORMATION_PATH_ID ="/{id}";
    public static final String FORMATION_PATH_CODE ="/{code}";
    public static final String FORMATION_PATH_TITRE ="/{titre}";

    public static final String CATEGORY="/categories";
    public static final String CATEGORY_PATH_VARIABLE_ID ="id";
    public static final String CATEGORY_PATH_VARIABLE_CODE ="code";
    public static final String CATEGORY_PATH_VARIABLE_TITRE ="titre";
    public static final String CATEGORY_PATH_ID ="/{id}";
    public static final String CATEGORY_PATH_CODE ="/{code}";
    public static final String CATEGORY_PATH_TITRE ="/{titre}";

    public static final String SALLE="/salles";
    public static final String SALLE_PATH_VARIABLE_ID ="id";
    public static final String SALLE_PATH_VARIABLE_CODE ="code";
    public static final String SALLE_PATH_ID ="/{id}";
    public static final String SALLE_PATH_CODE ="/{code}";

    public static final String CLIENT="/clients";
    public static final String CLIENT_PATH_VARIABLE_ID ="id";
    public static final String CLIENT_PATH_VARIABLE_NOM ="nom";
    public static final String CLIENT_PATH_VARIABLE_PRENOM ="prenom";
    public static final String CLIENT_PATH_VARIABLE_NUM_TEL ="num_tel";
    public static final String CLIENT_PATH_ID ="/{id}";
    public static final String CLIENT_PATH_NOM ="/{nom}";
    public static final String CLIENT_PATH_PRENOM ="/{prenom}";
    public static final String CLIENT_PATH_NUM_TEL ="/{num_tel}";

    public static final String COMMANDE_CLIENT="/commande_clients";
    public static final String COMMANDE_CLIENT_PATH_VARIABLE_ID ="id";
    public static final String COMMANDE_CLIENT_PATH_VARIABLE_CODE ="code";
    public static final String COMMANDE_CLIENT_PATH_ID ="/{id}";
    public static final String COMMANDE_CLIENT_PATH_CODE ="/{code}";

    public static final String FORMATEUR="/formateurs";
    public static final String FORMATEUR_PATH_VARIABLE_ID ="id";
    public static final String FORMATEUR_PATH_VARIABLE_NOM ="nom";
    public static final String FORMATEUR_PATH_VARIABLE_PRENOM ="prenom";
    public static final String FORMATEUR_PATH_VARIABLE_NUM_TEL ="num_tel";
    public static final String FORMATEUR_PATH_ID ="/{id}";
    public static final String FORMATEUR_PATH_NOM ="/{nom}";
    public static final String FORMATEUR_PATH_PRENOM ="/{prenom}";
    public static final String FORMATEUR_PATH_NUM_TEL ="/{num_tel}";

    public static final String DATE_FORMATION="/date_formations";
    public static final String DATE_FORMATION_PATH_VARIABLE_ID ="id";
    public static final String DATE_FORMATION_PATH_ID ="/{id}";

    public static final String NIVEAU="/niveaux";
    public static final String NIVEAU_PATH_VARIABLE_ID ="id";
    public static final String NIVEAU_PATH_VARIABLE_TITRE ="titre";
    public static final String NIVEAU_PATH_ID ="/{id}";
    public static final String NIVEAU_PATH_TITRE ="/{titre}";

    public static final String ENTREPRISE="/entreprises";
    public static final String ENTREPRISE_PATH_VARIABLE_ID ="id";
    public static final String ENTREPRISE_PATH_VARIABLE_NOM ="nom";
    public static final String ENTREPRISE_PATH_ID ="/{id}";
    public static final String ENTREPRISE_PATH_NOM ="/{nom}";


    public static final String VENTES="/ventes";
    public static final String VENTES_PATH_VARIABLE_ID ="id";
    public static final String VENTES_PATH_VARIABLE_CODE ="code";
    public static final String VENTES_PATH_ID ="/{id}";
    public static final String VENTES_PATH_CODE ="/{code}";

    public static final String UTILISATEUR="/utilisateur";
    public static final String UTILISATEUR_PATH_VARIABLE_ID ="id";
    public static final String UTILISATEUR_PATH_VARIABLE_CODE ="code";
    public static final String UTILISATEUR_PATH_ID ="/{id}";
    public static final String UTILISATEUR_PATH_CODE ="/{code}";

    public static final String BY_ENTREPRISE_ID = "/by_entreprise_id";
    public static final String BY_CATEGORY_ID = "/by_categorie_id";
    public static final String BY_FORMATION_ID = "/by_formation_id";
    public static final String BY_FORMATEUR_ID = "/by_formateur_id";
    public static final String BY_DATE_FORMATION_ID = "/by_date_formation_id";


}
