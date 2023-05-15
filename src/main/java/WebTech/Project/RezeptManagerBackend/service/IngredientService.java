package WebTech.Project.RezeptManagerBackend.service;

import WebTech.Project.RezeptManagerBackend.persistence.IngredientEntity;
import WebTech.Project.RezeptManagerBackend.persistence.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository repository;


    public List<IngredientEntity> findAll(){
        return repository.findAll();
    }
    public IngredientEntity createIngredient(IngredientEntity ingredientEntity) {
        return repository.save(ingredientEntity);
    }

    public List<IngredientEntity> findByVegetarian(boolean isVegetarian) {
        return repository.findIngredientEntitiesByVegetarian(isVegetarian);
    }

    public List<IngredientEntity> findByVegan(boolean isVegan) {
        return repository.findByVegan(isVegan);
    }

    public IngredientEntity findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public IngredientEntity findByName(String name) {
        var ingredientEntity = repository.findFirstByName(name);
        return ingredientEntity.isPresent()? ingredientEntity.get() : null;
    }

    public IngredientEntity updateIngredient(Long id, IngredientEntity entity) {
        var ingredientEntityOptional = repository.findById(id);
        if (ingredientEntityOptional.isEmpty()) {
            return null;
        }
        var ingredientEntity = ingredientEntityOptional.get();
        ingredientEntity.setName(entity.getName());
        ingredientEntity.setVegetarian(entity.isVegetarian());
        ingredientEntity.setVegan(entity.isVegan());
        ingredientEntity = repository.save(ingredientEntity);
        return ingredientEntity;
    }

    public boolean deleteIngredient (Long id) {
        if (!repository.existsById(id)) {
            return false;
        } else{repository.deleteById(id);
            return true;}

    }
}
