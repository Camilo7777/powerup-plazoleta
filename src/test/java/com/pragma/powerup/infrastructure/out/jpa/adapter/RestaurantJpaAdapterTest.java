package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.RestaurantEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRestaurantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class RestaurantJpaAdapterTest {

    @Mock
    private  IRestaurantRepository restaurantRepositoryMock;
    @Mock
    private  IRestaurantEntityMapper restaurantEntityMapperMock;

    @InjectMocks
    private RestaurantJpaAdapter restaurantJpaAdapterMock;

    @Test
    void saveRestaurant() {

        RestaurantModel restaurantModelMock =
                new RestaurantModel(1L,"pepe","1234","ddfef","34dff"
                        ,"2345",2L);
        RestaurantModel restaurantModelMock2 =
                new RestaurantModel(1L,"pepe","1234","ddfef","34dff"
                        ,"2345",2L);

        RestaurantEntity restaurantEntityMock =
                new RestaurantEntity(1L,"pepe","1234","ddfef","34dff"
                ,"2345",2L);

        RestaurantEntity restaurantEntityMock2 =
                new RestaurantEntity(1L,"pepe","1234","ddfef","34dff"
                        ,"2345",2L);

        List<RestaurantModel> lisMock2 = Arrays.asList(restaurantModelMock
                ,restaurantModelMock2);

        List<RestaurantEntity> lisMock = Arrays.asList(restaurantEntityMock
        ,restaurantEntityMock2);

        Mockito.when(restaurantRepositoryMock.findAll())
                .thenReturn(lisMock);

        Mockito.when(restaurantEntityMapperMock
                .toRestaurantModelList(lisMock));

        restaurantJpaAdapterMock.getAllRestaurants();

        Mockito.when(restaurantEntityMapperMock.toRestaurantModelList(any()))
                .thenReturn(lisMock2);

        Assertions.assertEquals(1L,lisMock2.get(0).getId());
    }
}