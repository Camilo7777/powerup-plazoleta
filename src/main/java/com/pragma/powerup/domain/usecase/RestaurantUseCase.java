package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.exception.WrongDataException;
import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;

import java.util.List;

public class RestaurantUseCase implements IRestaurantServicePort {

    private static final int DIGITS = 13;
    private final IRestaurantPersistencePort restaurantPersistencePort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public void saveRestaurant(RestaurantModel restaurantModel) {
        nitVerify(restaurantModel.getNit());
        phoneVerify(restaurantModel.getPhone());
        nameVerify(restaurantModel.getName());
        restaurantPersistencePort.saveRestaurant(restaurantModel);
    }

    @Override
    public List<RestaurantModel> getAllRestaurants() {
        List<RestaurantModel> restaurantModelList = restaurantPersistencePort.getAllRestaurants();
        if (restaurantModelList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return restaurantModelList;
    }

    private void nitVerify(String nit) {
        if (!nit.chars().allMatch(Character::isDigit)) {
            throw new WrongDataException();
        }
    }

    private void phoneVerify(String phone) {
        if ((phone.replace("+", "").length() >= DIGITS)) {
            throw new WrongDataException();
        }
    }

    private void nameVerify(String name) {
        if (name.chars().allMatch(Character::isDigit)) {
            throw new WrongDataException();
        }
    }

}
