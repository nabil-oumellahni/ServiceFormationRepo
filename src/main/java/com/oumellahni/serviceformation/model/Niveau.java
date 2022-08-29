package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author N.Oumellahni
 * at 10:16 AM - 8/18/2022
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "niveaux")
public class Niveau extends AbstractEntity {

    @Column
    private String titre;

    @ManyToOne
    @JoinColumn
    private Formation formation;

}
