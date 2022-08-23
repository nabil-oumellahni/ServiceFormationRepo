package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author N.Oumellahni
 * at 7:37 PM - 8/17/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class LigneCommandeClient extends AbstractEntity {

    @Column
    private BigDecimal prixUnitaire;

    @ManyToOne
    @JoinColumn(name = "id_commandeclient")
    private CommandeClient commandeClient;
}
