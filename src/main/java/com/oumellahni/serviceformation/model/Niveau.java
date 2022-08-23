package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author N.Oumellahni
 * at 10:16 AM - 8/18/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "niveaux")
public class Niveau extends AbstractEntity {

    @Column
    private String titre;

    @ManyToOne
    @JoinColumn(name = "id_formation")
    private Formation formation;
}
