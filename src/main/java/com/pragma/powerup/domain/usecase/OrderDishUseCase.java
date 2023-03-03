package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IDishServicePort;
import com.pragma.powerup.domain.api.IOrderDishServicePort;
import com.pragma.powerup.domain.exception.WrongDataException;
import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.model.OrderDishModel;
import com.pragma.powerup.domain.spi.IDishPersistencePort;
import com.pragma.powerup.domain.spi.IOrderDishPersistencePort;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class OrderDishUseCase implements IOrderDishServicePort {
    private final IOrderDishPersistencePort persistencePort;

    public OrderDishUseCase(IOrderDishPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public void saveOrderDish(OrderDishModel orderDishModel) {
        persistencePort.saveOrderDish(orderDishModel);
    }
}
