package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 7:45 PM - 8/17/2022
 */

 @Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Formation extends AbstractEntity {

    @Column
    private String code;

    @Column
    private String titre;

    @Column
    private String designation;

    @Column
    private BigDecimal prixUnitaireHt;

    @Column
    private BigDecimal tauxTva;

    @Column
    private BigDecimal prixUnitaireTtc;

    @Column
    private String photo;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @OneToMany(mappedBy = "formation")
    private List<Salle> salles;

    @OneToMany(mappedBy = "formation")
    private List<Niveau> niveaux;

    @ManyToOne
    @JoinColumn(name = "id_formateur")
    private Formateur formateur;

    @ManyToOne
    @JoinColumn(name = "id_date_formation")
    private DateFormation dateFormation;

}


//    @Column(name = "identreprise")
//    private Integer idEntreprise;

//    @OneToMany(mappedBy = "article")
//    private List<LigneVente> ligneVentes;

//    @OneToMany(mappedBy = "article")
//    private List<LigneCommandeClient> ligneCommandeClients;

//    @OneToMany(mappedBy = "article")
//    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

//    @OneToMany(mappedBy = "article")
//    private List<MvtStk> mvtStks;
