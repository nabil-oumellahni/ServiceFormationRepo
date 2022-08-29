package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

/**
 * @author N.Oumellahni
 * at 7:49 PM - 8/17/2022
 */

@Setter
@Getter
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
