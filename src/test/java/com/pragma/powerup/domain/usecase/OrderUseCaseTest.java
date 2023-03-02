package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.model.OrderModel;
import com.pragma.powerup.domain.spi.IOrderPersistencePort;
import com.pragma.powerup.infrastructure.out.jpa.entity.OrderEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
class OrderUseCaseTest {
    @Mock
    private  IOrderPersistencePort persistencePortMock;

    @InjectMocks
    private OrderUseCase orderUseCaseMock;
    @Test
    void saveOrder() {
        OrderModel orderModelMock = new OrderModel(
                1L,1L,new Date(),"pendiente",
                2L,2L, Collections.emptyList()
        );

        OrderEntity orderEntityMock = new OrderEntity(
                1L,1L,new Date(),"pendiente",
                2L,2L, Collections.emptyList()
        );

        orderUseCaseMock.saveOrder(orderModelMock);

        Mockito.verify(persistencePortMock, Mockito.times(1))
                .saveOrder(orderModelMock);
    }
}