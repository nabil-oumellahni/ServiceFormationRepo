package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 7:49 PM - 8/17/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Category extends AbstractEntity {

    @Column
    private String code;

    @Column
    private String titre;

    @Column
    private String designation;

    @OneToMany(mappedBy = "category")
    private List<Formation> formations;
}
