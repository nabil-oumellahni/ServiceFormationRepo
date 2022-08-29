package com.oumellahni.serviceformation.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author N.Oumellahni
 * at 4:27 PM - 8/17/2022
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adresse implements Serializable {

    @Column
    private String adresse;

    @Column
    private String ville;

    @Column
    private String pays;
}
