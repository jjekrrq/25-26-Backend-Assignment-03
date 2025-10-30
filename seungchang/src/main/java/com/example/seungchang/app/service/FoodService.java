package com.example.seungchang.app.service;

import com.example.seungchang.app.domain.Food;
import com.example.seungchang.app.domain.Restaurant;
import com.example.seungchang.app.dto.food.FoodRequestDto;
import com.example.seungchang.app.dto.food.FoodResponseDto;
import com.example.seungchang.app.mapper.FoodMapper;
import com.example.seungchang.app.repository.FoodRepository;
import com.example.seungchang.app.repository.RestaurantRepository;
import com.example.seungchang.global.exception.RestaurantNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public FoodResponseDto createFood(Long id,FoodRequestDto foodRequestDto){
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        Food food = foodMapper.toEntity(foodRequestDto, restaurant);
        Food saved = foodRepository.save(food);
        return foodMapper.toDto(saved);
    }
}
