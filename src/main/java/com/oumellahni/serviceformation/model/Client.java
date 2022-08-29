package com.oumellahni.serviceformation.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author N.Oumellahni
 * at 4:33 PM - 8/17/2022
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
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
    @JoinColumn()
    private Entreprise entreprise;

    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;

}
