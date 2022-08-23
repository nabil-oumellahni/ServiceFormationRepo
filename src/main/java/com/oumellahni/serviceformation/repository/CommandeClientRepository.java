package com.oumellahni.serviceformation.repository;

import com.oumellahni.serviceformation.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author N.Oumellahni
 * at 3:25 PM - 8/18/2022
 */

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {

    Optional<CommandeClient>findCommandeClientByCode(String code);

    List<CommandeClient>findAllByClientId(Integer idClient);
}
