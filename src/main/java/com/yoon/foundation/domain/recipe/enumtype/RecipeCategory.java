package com.yoon.foundation.domain.recipe.enumtype;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RecipeCategory {
    BIG_SPOON("BIG_SPOON",15 ),
    SMALL_SPOON("SMALL_SPOON", 5);


    private final String key;
    private final Integer Value;
}
