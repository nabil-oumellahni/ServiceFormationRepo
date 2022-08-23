package com.oumellahni.serviceformation.repository;

import com.oumellahni.serviceformation.model.Formateur;
import com.oumellahni.serviceformation.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author N.Oumellahni
 * at 3:30 PM - 8/18/2022
 */

public interface FormateurRepository extends JpaRepository<Formateur , Integer> {

    Optional<Formateur> findFormateurByNom(String nom);

    Optional<Formateur> findFormateurByPrenom(String prenom);

    Optional<Formateur> findFormateurByNumTel(String numTel);

}
