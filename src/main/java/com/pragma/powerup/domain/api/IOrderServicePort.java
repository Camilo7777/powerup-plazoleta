package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.OrderDishModel;
import com.pragma.powerup.domain.model.OrderModel;
import java.util.List;

public interface IOrderServicePort {
    void saveOrder(OrderModel orderModel);

    List<OrderModel> findByStatus(String status);


}
