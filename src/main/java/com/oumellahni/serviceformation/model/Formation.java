package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 7:45 PM - 8/17/2022
 */

@Setter
@Getter
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
    @JoinColumn()
    private Category category;

    @OneToMany(mappedBy = "formation")
    private List<Salle> salles;

    @OneToMany(mappedBy = "formation")
    private List<Niveau> niveaux;

    @ManyToOne
    @JoinColumn()
    private Formateur formateur;

    @ManyToOne
    @JoinColumn()
    private DateFormation dateFormation;

        @OneToMany(mappedBy = "formation")
    private List<LigneCommandeClient> ligneCommandeClients;

}


//    @Column(name = "identreprise")
//    private Integer idEntreprise;

//    @OneToMany(mappedBy = "article")
//    private List<LigneVente> ligneVentes;

//    @OneToMany(mappedBy = "article")
//    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

//    @OneToMany(mappedBy = "article")
//    private List<MvtStk> mvtStks;
