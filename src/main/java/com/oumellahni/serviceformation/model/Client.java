package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 4:33 PM - 8/17/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client extends AbstractEntity {

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

    @ManyToOne
    @JoinColumn(name = "id_entreprise")
    private Entreprise entreprise;

    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;


//    @Column(name = "identreprise")
//    private Integer idEntreprise;
//

}
