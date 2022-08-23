package com.oumellahni.serviceformation.repository;

import com.oumellahni.serviceformation.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author N.Oumellahni
 * at 3:33 PM - 8/18/2022
 */

public interface SalleRepository extends JpaRepository<Salle, Integer> {

    Optional<Salle> findSalleByCode(String code);

    List<Salle>findAllByFormationId(Integer idFormation);
}
