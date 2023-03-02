package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.RestaurantModel;

import java.util.List;

public interface IRestaurantPersistencePort {
    void saveRestaurant(RestaurantModel restaurantModel);
    List<RestaurantModel> getAllRestaurants(Integer pages);
}
