package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.RestaurantResquestDto;
import com.pragma.powerup.application.dto.response.RestaurantResponseDto;
import com.pragma.powerup.application.mapper.IRestaurantRequestMapper;
import com.pragma.powerup.application.mapper.IRestaurantResponseMapper;
import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.model.RestaurantModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
class RestaurantHandlerTest {
    @Mock
    private  IRestaurantServicePort servicePortMock;
    @Mock
    private  IRestaurantRequestMapper restaurantRequestMapperMock;

    @Mock
    private  IRestaurantResponseMapper responseMapperMock;

    @InjectMocks
   private RestaurantHandler restaurantHandlerMock;

    @Test
    void saveRestaurant() {

        RestaurantResquestDto restaurantResquestDtoMock =
                RestaurantResquestDto.builder()
                        .idUser(1L)
                        .url("werty")
                        .nit("234567")
                        .idRestaurant(2L)
                        .phone("234567")
                        .address("wertyhewj")
                        .name("dihdihwqd")
                        .build();

        RestaurantModel restaurantModelMock =
                new RestaurantModel(2L,"pepe","4567","gdgugd"
                ,"yd8ud","345678",2L);

        Mockito.when(restaurantRequestMapperMock
                .toResponse(any()))
                .thenReturn(restaurantModelMock);

        Mockito.doNothing()
                .when(servicePortMock).saveRestaurant(any());


        restaurantHandlerMock.
                saveRestaurant(restaurantResquestDtoMock);

        Mockito.verify(servicePortMock,Mockito.times(1))
                .saveRestaurant(any());


    }

    @Test
    void getAllRestaurants() {

        RestaurantResponseDto restaurantResponseDtoMock =
                RestaurantResponseDto.builder()
                        .name("donde marta")
                        .url("2dewp´ñldw")
                        .build();

        RestaurantModel restaurantModelMock =
                new RestaurantModel(2L,"pepe","4567","gdgugd"
                        ,"yd8ud","345678",2L);

        Mockito.when(responseMapperMock.toResponseList(any()))
                .thenReturn(List.of(restaurantResponseDtoMock));

        Mockito.when(servicePortMock.getAllRestaurants(any()))
                .thenReturn(List.of(restaurantModelMock));

        var restaurantList = restaurantHandlerMock.getAllRestaurants(any());

        Assertions.assertEquals("donde marta",restaurantList.get(0).getName());


    }
}