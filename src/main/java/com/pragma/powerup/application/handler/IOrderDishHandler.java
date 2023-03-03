package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.OrderDishResquestDto;
import com.pragma.powerup.application.dto.request.OrderRequestDto;
import com.pragma.powerup.application.dto.response.OrderResponseDto;
import com.pragma.powerup.domain.model.OrderDishModel;

import java.util.List;

public interface IOrderDishHandler {
    void saveOrderDish(OrderDishResquestDto orderDishResquestDto);
}
