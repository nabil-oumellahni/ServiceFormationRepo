package com.oumellahni.serviceformation.repository;

import com.oumellahni.serviceformation.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author N.Oumellahni
 * at 3:29 PM - 8/18/2022
 */

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

    Optional<Entreprise> findEntrepriseByNom(String nom);
}
