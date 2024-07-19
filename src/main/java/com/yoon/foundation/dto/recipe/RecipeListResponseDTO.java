package com.yoon.foundation.dto.recipe;

import com.yoon.foundation.domain.recipe.Recipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecipeListResponseDTO {
    private List<Recipe> recipes;
}
