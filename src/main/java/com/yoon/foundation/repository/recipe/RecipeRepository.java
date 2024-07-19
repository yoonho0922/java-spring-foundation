package com.yoon.foundation.repository.recipe;

import com.yoon.foundation.domain.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository  extends JpaRepository<Recipe,Long>, RecipeCustomRepository {
}
