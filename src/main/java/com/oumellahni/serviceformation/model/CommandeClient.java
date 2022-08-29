package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * @author N.Oumellahni
 * at 7:20 PM - 8/17/2022
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class CommandeClient extends AbstractEntity {

    @Column
    private Instant dateCommande;

    @Column
    private String code;

    @Column()
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;

    @ManyToOne
    @JoinColumn()
    private Client client;

    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;

}
