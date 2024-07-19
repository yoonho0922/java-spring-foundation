package com.yoon.foundation.dto.recipe;

import com.yoon.foundation.domain.recipe.Ingredient;
import com.yoon.foundation.domain.recipe.Recipe;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecipeResponseDTO {
    private Recipe recipe;
    private List<Ingredient> ingredients;
    private Integer reducedCo2;

}
