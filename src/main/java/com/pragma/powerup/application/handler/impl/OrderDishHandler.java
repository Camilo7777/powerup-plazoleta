package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.DishResquestDto;
import com.pragma.powerup.application.dto.request.OrderDishResquestDto;
import com.pragma.powerup.application.dto.response.DishResponseDto;
import com.pragma.powerup.application.handler.IDishHandler;
import com.pragma.powerup.application.handler.IOrderDishHandler;
import com.pragma.powerup.application.mapper.*;
import com.pragma.powerup.domain.api.IDishServicePort;
import com.pragma.powerup.domain.api.IOrderDishServicePort;
import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.model.OrderDishModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class OrderDishHandler implements IOrderDishHandler {

    private final IOrderDishServicePort servicePort;
    private final IOrderDishRequestMapper orderDishRequestMapper;

    private  final IOrderDishResponseMapper orderDishResponseMapper;
    @Override
    public void saveOrderDish(OrderDishResquestDto orderDishResquestDto) {
        OrderDishModel orderDishModel = orderDishRequestMapper.toResponse(orderDishResquestDto);
    }
}
