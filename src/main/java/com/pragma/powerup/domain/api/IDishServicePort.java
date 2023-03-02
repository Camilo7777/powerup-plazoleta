package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.DishModel;

import java.util.List;
import java.util.Map;

public interface IDishServicePort {
    void saveDish(DishModel dishModel);
    DishModel findById(Long id);

    void updateDish(DishModel dishModel);

    void enableDisableDish(Long dishId);

    List<DishModel> findByRestaurantId(Long id,Integer pages);

}
