package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.model.OrderDishModel;



public interface IOrderDishPersistencePort {
    void saveOrderDish(OrderDishModel orderDishModel);

}
