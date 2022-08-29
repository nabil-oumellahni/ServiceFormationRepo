package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 4:25 PM - 8/17/2022
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Entreprise extends AbstractEntity {

    @Column
    private String nom;

    @Column
    private String description;

    @Embedded
    private Adresse adresse;

    @Column
    private String filiale;

    @Column
    private String email;

    @Column
    private String numTel;

    @Column
    private String siteWeb;

    @OneToMany(mappedBy = "entreprise")
    private List<Client> clients;

//    @OneToMany(mappedBy = "entreprise")
//    private List<Utilisateur> utilisateurs;

}
