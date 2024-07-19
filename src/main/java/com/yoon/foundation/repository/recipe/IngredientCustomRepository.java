package com.yoon.foundation.repository.recipe;

import com.yoon.foundation.domain.recipe.Ingredient;

import java.util.List;

public interface IngredientCustomRepository {
    List<Ingredient> findIngredientList(Long id);
}
