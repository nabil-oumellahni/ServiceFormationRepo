package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author N.Oumellahni
 * at 7:37 PM - 8/17/2022
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class LigneCommandeClient extends AbstractEntity {

    @Column
    private BigDecimal prixUnitaire;

    @ManyToOne
    @JoinColumn
    private CommandeClient commandeClient;

    @ManyToOne
    @JoinColumn
    private Formation formation;
}
