package com.example.seungchang.global.exception;

import com.example.seungchang.app.domain.Food;

public class FoodNotFoundException extends RuntimeException{
    public FoodNotFoundException(Long id){
        super("Food with id " + id + " not found.");
    }
}
