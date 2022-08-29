package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author N.Oumellahni
 * at 7:53 PM - 8/17/2022
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Salle extends AbstractEntity {

    @Column
    private String code;

    @ManyToOne
    @JoinColumn
    private Formation formation;

}
