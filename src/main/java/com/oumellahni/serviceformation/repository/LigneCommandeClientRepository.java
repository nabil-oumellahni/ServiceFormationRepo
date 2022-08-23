package com.oumellahni.serviceformation.repository;

import com.oumellahni.serviceformation.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author N.Oumellahni
 * at 3:31 PM - 8/18/2022
 */

public interface LigneCommandeClientRepository extends JpaRepository <LigneCommandeClient , Integer>{


    Optional<LigneCommandeClient>findAllByCommandeClientId(Integer idCommandeClient);

    //may be ByCommandeClientCode
    Optional<LigneCommandeClient>findAllByCommandeClientCode(String codeCommandeClient);

//    List<LigneCommandeClient> findAllByArticleId(Integer id);
}
