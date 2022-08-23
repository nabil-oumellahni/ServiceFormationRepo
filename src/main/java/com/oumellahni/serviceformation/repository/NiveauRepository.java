package com.oumellahni.serviceformation.repository;

import com.oumellahni.serviceformation.model.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author N.Oumellahni
 * at 3:33 PM - 8/18/2022
 */

public interface NiveauRepository extends JpaRepository<Niveau , Integer> {

    Optional<Niveau> findNiveauByTitre(String titre);


}
