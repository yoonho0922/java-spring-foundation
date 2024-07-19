package com.yoon.foundation.repository.recipe;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yoon.foundation.domain.recipe.Ingredient;
import com.yoon.foundation.domain.recipe.QIngredient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class IngredientRepositoryImpl implements IngredientCustomRepository{

    private final JPAQueryFactory queryFactory;
    @Override
    public List<Ingredient> findIngredientList(Long id) {
        return queryFactory
                .select(QIngredient.ingredient)
                .from(QIngredient.ingredient)
                .where(QIngredient.ingredient.recipeId.eq(id))
                .fetch();
    }
}
