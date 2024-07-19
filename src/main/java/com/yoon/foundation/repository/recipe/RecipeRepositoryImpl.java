package com.yoon.foundation.repository.recipe;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yoon.foundation.domain.recipe.QRecipe;
import com.yoon.foundation.domain.recipe.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RecipeRepositoryImpl implements RecipeCustomRepository {

    private final JPAQueryFactory queryFactory;


    @Override
    public Recipe findRecipe(Long id) {
        return Optional.ofNullable( queryFactory
                .select(QRecipe.recipe1)
                .from(QRecipe.recipe1)
                .where(QRecipe.recipe1.id.eq(id))
                .fetchOne())
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Recipe> findRecipeList() {
        return queryFactory
                .select(QRecipe.recipe1)
                .from(QRecipe.recipe1)
                .fetch();
    }
}
