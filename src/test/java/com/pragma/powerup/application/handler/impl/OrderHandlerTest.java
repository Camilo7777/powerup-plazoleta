package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.OrderRequestDto;
import com.pragma.powerup.application.mapper.IOrderRequestMapper;
import com.pragma.powerup.application.mapper.IOrderResponseMapper;
import com.pragma.powerup.domain.api.IOrderServicePort;
import com.pragma.powerup.domain.model.OrderModel;
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
class OrderHandlerTest {

    @Mock
    private IOrderServicePort servicePortMock;
    @Mock
    private IOrderRequestMapper orderRequestMapperMock;
    @Mock
    private IOrderResponseMapper orderResponseMapperMock;

    @InjectMocks
    private OrderHandler orderHandlerMock;
    @Test
    void saveOrder() {
        OrderRequestDto orderRequestDtoMock = new OrderRequestDto(
                1L,1L,new Date(),"pendiente",
                2L,2L, Collections.emptyList()
        );

        OrderModel orderModelMock = new OrderModel(
                1L,1L,new Date(),"pendiente",
                2L,2L, Collections.emptyList()
        );

        Mockito.when(orderRequestMapperMock.toResponse(any()))
                .thenReturn(orderModelMock);

        orderHandlerMock.saveOrder(orderRequestDtoMock);

        Mockito.verify(servicePortMock, Mockito.times(1))
                .saveOrder(orderModelMock);
    }
}