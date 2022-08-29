package com.oumellahni.serviceformation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @author N.Oumellahni
 * at 10:26 AM - 8/18/2022
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class DateFormation extends AbstractEntity {

    @Column
    private Date date;

    //----------------------------------------------------------------
    // TODO : may be we have dateDebut and dateFin
    //----------------------------------------------------------------

    @OneToMany(mappedBy = "dateFormation")
    private List<Formation> formations;

}
