package com.yoon.foundation.controller.recipe;

import com.yoon.foundation.common.response.CommonResponse;
import com.yoon.foundation.service.recipe.RecipeQueryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/recipe")
public class RecipeQueryController {
    private final RecipeQueryService recipeQueryService;

    @GetMapping("/{recipeId}")
    public CommonResponse<Object> findRecipe(
            @PathVariable("recipeId") Long recipeId,
            @RequestParam Long memberId
    )
    {
        return recipeQueryService.findRecipe(recipeId, memberId);
    }

    @GetMapping()
    public CommonResponse<Object> findRecipeList() {
        return recipeQueryService.findRecipeList();
    }
}

