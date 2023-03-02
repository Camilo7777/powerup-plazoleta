package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.RestaurantEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRestaurantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
class RestaurantJpaAdapterTest {

    @Mock
    private  IRestaurantRepository restaurantRepositoryMock;
    @Mock
    private  IRestaurantEntityMapper restaurantEntityMapperMock;

    @InjectMocks
    private RestaurantJpaAdapter restaurantJpaAdapterMock;

    @Test
    void saveRestaurant() {

        RestaurantEntity restaurantEntityMock =
                new RestaurantEntity(1L,"pepe","1234","ddfef","34dff"
                        ,"2345",2L);

        Mockito.when(restaurantEntityMapperMock.toEntity(any()))
                .thenReturn(restaurantEntityMock);

        restaurantJpaAdapterMock.saveRestaurant(any());

        Mockito.verify(restaurantRepositoryMock, Mockito.times(1))
                .save(restaurantEntityMock);
    }

    @Test
    void getAllRestaurants() {

        Pageable sortedByName =
                PageRequest.of(0,  any(), Sort.by("name"));

        RestaurantModel restaurantModel = new RestaurantModel(1L,"pepe","1234","ddfef","34dff"
                ,"2345",2L);


        Mockito.when(restaurantRepositoryMock.findAll(sortedByName).toList())
                .thenReturn(List.of(new RestaurantEntity(1L,"pepe","1234","ddfef","34dff"
                        ,"2345",2L)));

        Mockito.when(restaurantEntityMapperMock.toRestaurantModelList(any()))
                .thenReturn(List.of(restaurantModel));

        var restaurant = restaurantJpaAdapterMock.getAllRestaurants(any());

        Assertions.assertEquals(1L,restaurant.get(0).getIdRestaurant());
    }
}