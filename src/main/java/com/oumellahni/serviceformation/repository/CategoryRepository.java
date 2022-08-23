package com.oumellahni.serviceformation.repository;

import com.oumellahni.serviceformation.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author N.Oumellahni
 * at 3:23 PM - 8/18/2022
 */

public interface CategoryRepository extends JpaRepository<Category , Integer> {

    Optional<Category> findCategoryByCode(String code);

    Optional<Category> findCategoryByTitre(String titre);

}
