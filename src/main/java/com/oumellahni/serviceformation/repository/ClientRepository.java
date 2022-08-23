package com.oumellahni.serviceformation.repository;

import com.oumellahni.serviceformation.model.Category;
import com.oumellahni.serviceformation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author N.Oumellahni
 * at 3:24 PM - 8/18/2022
 */

public interface ClientRepository extends JpaRepository<Client , Integer> {

    Optional<Client> findClientByNom(String nom);

    Optional<Client> findClientByPrenom(String prenom);

    Optional<Client> findClientByNumTel(String numTel);

    List<Client> findAllByEntrepriseId(Integer idEntreprise);
}
