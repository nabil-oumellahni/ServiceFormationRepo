package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:22 AM - 8/18/2022
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Formateur extends AbstractEntity {

    @Column
    private String nom;

    @Column
    private String prenom;

    @Embedded
    private Adresse adresse;

    @Column
    private String photo;

    @Column
    private String email;

    @Column
    private String numTel;

    @OneToMany(mappedBy = "formateur")
    private List<Formation> formations;

//    @OneToMany(mappedBy = "fournisseur")
//    private List<CommandeFournisseur> commandeFournisseurs;

}
