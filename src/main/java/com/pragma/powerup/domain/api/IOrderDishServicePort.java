package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.model.OrderDishModel;

import java.util.List;

public interface IOrderDishServicePort {
    void saveOrderDish(OrderDishModel orderDishModel);
}
