package com.example.seungchang.app.dto.food;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class FoodResponseDto {
    private Long id;
    private String FoodName;
    private int kcal;
    private int amountOfSelling;
    private Long restaurantId;
    private String restaurantName;
}
