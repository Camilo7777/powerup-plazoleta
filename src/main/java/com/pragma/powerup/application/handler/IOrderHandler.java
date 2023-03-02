package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.OrderRequestDto;
import com.pragma.powerup.application.dto.response.OrderResponseDto;
import com.pragma.powerup.domain.model.OrderModel;

import java.util.List;

public interface IOrderHandler {

    void saveOrder(OrderRequestDto orderRequestDto);

    List<OrderResponseDto> findByStatus(String status);

}
