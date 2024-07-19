package com.yoon.foundation.domain.recipe;

import com.yoon.foundation.domain.recipe.enumtype.RecipeCategory;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="TB_RECIPE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(length = 12235)
    private String recipe;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column
    private String category;
}
