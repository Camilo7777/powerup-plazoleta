package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.RestaurantResquestDto;
import com.pragma.powerup.application.dto.response.RestaurantResponseDto;
import com.pragma.powerup.application.handler.IRestaurantHandler;
import com.pragma.powerup.application.mapper.IRestaurantRequestMapper;
import com.pragma.powerup.application.mapper.IRestaurantResponseMapper;
import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.model.RestaurantModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantHandler implements IRestaurantHandler {

    private final IRestaurantServicePort servicePort;
    private final IRestaurantRequestMapper restaurantRequestMapper;

    private final IRestaurantResponseMapper responseMapper;

    @Override
    public void saveRestaurant(RestaurantResquestDto restaurantResquestDto) {
        RestaurantModel restaurantModel = restaurantRequestMapper.toResponse(restaurantResquestDto);
        servicePort.saveRestaurant(restaurantModel);
    }
    @Override
    public List<RestaurantResponseDto> getAllRestaurants() {
        return responseMapper.toResponseList(servicePort.getAllRestaurants());
    }
}
