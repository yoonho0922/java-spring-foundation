package com.yoon.foundation.repository.recipe;

import com.yoon.foundation.domain.recipe.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>,IngredientCustomRepository {
}
