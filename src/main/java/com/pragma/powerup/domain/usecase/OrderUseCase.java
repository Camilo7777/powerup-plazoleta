package com.pragma.powerup.domain.usecase;
import com.pragma.powerup.domain.api.IOrderServicePort;
import com.pragma.powerup.domain.model.OrderModel;
import com.pragma.powerup.domain.spi.IOrderPersistencePort;

import java.util.List;

public class OrderUseCase implements IOrderServicePort {
    private final IOrderPersistencePort persistencePort;

    public OrderUseCase(IOrderPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public void saveOrder(OrderModel orderModel) {
        persistencePort.saveOrder(orderModel);
    }

    @Override
    public List<OrderModel> findByStatus(String status) {
        return persistencePort.findByStatus(status);
    }
}
