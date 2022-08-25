package com.oumellahni.serviceformation.service.ServiceImpl;

import com.oumellahni.serviceformation.dto.CategoryDto;
import com.oumellahni.serviceformation.exception.EntityNotFoundException;
import com.oumellahni.serviceformation.exception.ErrorCodes;
import com.oumellahni.serviceformation.exception.InvalidEntityException;
import com.oumellahni.serviceformation.exception.InvalidOperationException;
import com.oumellahni.serviceformation.model.Formation;
import com.oumellahni.serviceformation.repository.CategoryRepository;
import com.oumellahni.serviceformation.repository.FormationRepository;
import com.oumellahni.serviceformation.service.CategoryService;
import com.oumellahni.serviceformation.validator.CategoryValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author N.Oumellahni
 * at 11:20 AM - 8/19/2022
 */
@Service
@Slf4j
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private FormationRepository formationRepository;

    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if (! errors.isEmpty()) {
            log.error("Categorie n'est pas valide {}", dto);
            throw new InvalidEntityException(
                    "La categorie n'est pas valide.",
                    ErrorCodes.CATEGORY_NOT_VALID,
                    errors
            );
        }
        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(dto)));
    }

    @Override
    public CategoryDto findCategoryById(Integer id) {
        if (id == null) {
            log.error("ID de la categorie est nulle.");
            return null;
        }
        return categoryRepository.findById(id)
                .map(CategoryDto::fromEntity)
                .orElseThrow( () -> new  EntityNotFoundException(
                        "Aucune categorie avec ID =  " + id + " dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND
                ));
    }

    @Override
    public CategoryDto findCategoryByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("CODE de la categorie est nulle.");
            return null;
        }
        return categoryRepository.findCategoryByCode(code)
                .map(CategoryDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune categorie avec CODE = " + code + " dans la BDD.",
                        ErrorCodes.CATEGORY_NOT_FOUND
                ));
    }

    @Override
    public CategoryDto findCategoryByTitre(String titre) {
        if (!StringUtils.hasLength(titre)) {
            log.error("TITRE de la categorie est nulle.");
            return null;
        }
        return categoryRepository.findCategoryByTitre(titre)
                .map(CategoryDto :: fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune categorie avec TITRE = " + titre + " dans la BDD.",
                        ErrorCodes.CATEGORY_NOT_FOUND
                ));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream().map(CategoryDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID de la categorie est nulle.");
            return;
        }
        List<Formation> formations = formationRepository.findAllByCategoryId(id);
        if (!formations.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer cette categorie qui est deja utilise",
                    ErrorCodes.CATEGORY_ALREADY_IN_USE);
        }
        //----------------------------------------------------------------
        //TODO : make sure if list of formations is empty before the deleting category by id
        //----------------------------------------------------------------
        categoryRepository.delete(CategoryDto.toEntity(findCategoryById(id)));
    }

}
