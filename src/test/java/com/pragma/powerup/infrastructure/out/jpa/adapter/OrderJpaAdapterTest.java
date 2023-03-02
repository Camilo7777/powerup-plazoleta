package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.OrderModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.OrderEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IOrderEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IOrderRepository;
import org.junit.jupiter.api.MethodOrderer;
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
class OrderJpaAdapterTest {

    @Mock
    private  IOrderRepository orderRepositoryMock;
    @Mock
    private  IOrderEntityMapper orderEntityMapperMock;

    @InjectMocks
    OrderJpaAdapter orderJpaAdapterMock;
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

        Mockito.when(orderEntityMapperMock.toEntity(any()))
                .thenReturn(orderEntityMock);

        orderJpaAdapterMock.saveOrder(orderModelMock);

        Mockito.verify(orderRepositoryMock, Mockito.times(1))
                .save(orderEntityMock);

    }
}