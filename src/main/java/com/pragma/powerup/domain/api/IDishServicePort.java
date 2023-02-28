package com.pragma.powerup.domain.api;

import com.pragma.powerup.application.dto.response.DishResponseDto;
import com.pragma.powerup.domain.model.DishModel;

import java.util.List;

public interface IDishServicePort {
    void saveDish(DishModel dishModel);
    DishModel findById(Long id);

    void updateDish(DishModel dishModel);

    void enableDisableDish(Long dishId);

    List<DishModel> findByRestaurantId(Long id);
}
