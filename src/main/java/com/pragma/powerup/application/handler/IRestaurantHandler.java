package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.RestaurantResquestDto;
import com.pragma.powerup.application.dto.response.RestaurantResponseDto;


import java.util.List;

public interface IRestaurantHandler {

    void saveRestaurant(RestaurantResquestDto restaurantResquestDto);

    List<RestaurantResponseDto> getAllRestaurants(Integer pages);
}
