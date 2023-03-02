package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.DishResquestDto;
import com.pragma.powerup.application.dto.response.DishResponseDto;
import com.pragma.powerup.domain.model.DishModel;

import java.util.List;

public interface IDishHandler {

    void saveDish(DishResquestDto dishResquestDto);

    DishModel findById(Long id);

    public void updateDish(DishResquestDto dishResquestDto);


    void enableDisableDish(Long dishId);

    List<DishResponseDto> findByRestaurantId(Long id,Integer pages);
}
