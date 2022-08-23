package com.oumellahni.serviceformation.repository;

import com.oumellahni.serviceformation.model.Category;
import com.oumellahni.serviceformation.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author N.Oumellahni
 * at 3:31 PM - 8/18/2022
 */

public interface FormationRepository extends JpaRepository<Formation, Integer> {

    Optional<Formation> findFormationByTitre(String titre);

    Optional<Formation> findFormationByCode(String code);

    List<Formation>findAllByCategoryId(Integer idCategory);

    List<Formation>findAllByFormateurId(Integer idFormateur);

    List<Formation>findAllByDateFormationId(Integer idDateFormation);

}
