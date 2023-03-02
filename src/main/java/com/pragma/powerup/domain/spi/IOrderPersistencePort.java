package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.model.OrderModel;

import java.util.List;


public interface IOrderPersistencePort {
    void saveOrder(OrderModel orderModel);

    List<OrderModel> findByStatus(String status);


}
