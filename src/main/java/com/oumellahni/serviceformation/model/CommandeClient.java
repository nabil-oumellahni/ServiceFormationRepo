package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 7:20 PM - 8/17/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class CommandeClient extends AbstractEntity {

    @Column
    private Instant dateCommande;

    @Column
    private String code;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;
}
