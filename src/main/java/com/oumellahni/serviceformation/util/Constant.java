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

    public static final String AUTHENTICATE=APP_ROOT+"/authenticate";

    public static final String FORMATION="/formations";
    public static final String FORMATION_PATH_VARIABLE_ID ="id";
    public static final String FORMATION_PATH_VARIABLE_CODE ="code";
    public static final String FORMATION_PATH_ID ="/{id}";
    public static final String FORMATION_PATH_CODE ="/{code}";

    public static final String CATEGORY="/categories";
    public static final String CATEGORY_PATH_VARIABLE_ID ="id";
    public static final String CATEGORY_PATH_VARIABLE_CODE ="code";
    public static final String CATEGORY_PATH_ID ="/{id}";
    public static final String CATEGORY_PATH_CODE ="/{code}";

    public static final String CLIENT="/clients";
    public static final String CLIENT_PATH_VARIABLE_ID ="id";
    public static final String CLIENT_PATH_VARIABLE_NOM ="nom";
    public static final String CLIENT_PATH_VARIABLE_PRENOM ="prenom";
    public static final String CLIENT_PATH_VARIABLE_NUM_TEL ="numTel";
    public static final String CLIENT_PATH_ID ="/{id}";
    public static final String CLIENT_PATH_NOM ="/{nom}";
    public static final String CLIENT_PATH_PRENOM ="/{prenom}";
    public static final String CLIENT_PATH_NUM_TEL ="/{numTel}";

    public static final String COMMANDE_CLIENT="/commandeclients";
    public static final String COMMANDE_CLIENT_PATH_VARIABLE_ID ="id";
    public static final String COMMANDE_CLIENT_PATH_VARIABLE_CODE ="code";
    public static final String COMMANDE_CLIENT_PATH_ID ="/{id}";
    public static final String COMMANDE_CLIENT_PATH_CODE ="/{code}";

    public static final String FOURNISSEUR="/fournisseurs";
    public static final String FOURNISSEUR_PATH_VARIABLE_ID ="id";
    public static final String FOURNISSEUR_PATH_VARIABLE_CODE ="code";
    public static final String FOURNISSEUR_PATH_ID ="/{id}";
    public static final String FOURNISSEUR_PATH_CODE ="/{code}";

    public static final String COMMANDE_FOURNISSEUR="/commandefournisseurs";
    public static final String COMMANDE_FOURNISSEUR_PATH_VARIABLE_ID ="id";
    public static final String COMMANDE_FOURNISSEUR_PATH_VARIABLE_CODE ="code";
    public static final String COMMANDE_FOURNISSEUR_PATH_ID ="/{id}";
    public static final String COMMANDE_FOURNISSEUR_PATH_CODE ="/{code}";


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

}
