package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author N.Oumellahni
 * at 7:53 PM - 8/17/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Salle extends AbstractEntity {

    @Column
    private String code;

    @ManyToOne
    @JoinColumn(name = "id_formation")
    private Formation formation;



}
