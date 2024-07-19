package com.yoon.foundation.repository.recipe;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yoon.foundation.domain.recipe.Recipe;

import java.util.List;

public interface RecipeCustomRepository {
    Recipe findRecipe(Long id);

    List<Recipe> findRecipeList();
}
