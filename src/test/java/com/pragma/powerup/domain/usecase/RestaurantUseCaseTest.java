package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
class RestaurantUseCaseTest {
    @Mock
    private  IRestaurantPersistencePort restaurantPersistencePortMock;

    @InjectMocks
    RestaurantUseCase restaurantUseCaseMock;
    @Test
    void saveRestaurant() {
        RestaurantModel restaurantModelMock = new RestaurantModel(1L,"exito","123"
        ,"sdfgn","sdfgh","123456",2L);

        Mockito.doNothing()
                .when(restaurantPersistencePortMock)
                .saveRestaurant(any());

        restaurantUseCaseMock.saveRestaurant(restaurantModelMock);

        Mockito.verify(restaurantPersistencePortMock,Mockito.times(1))
                .saveRestaurant(any());

    }

    @Test
    @DisplayName("NitError")
    void saveRestaurantNitError() {
        RestaurantModel restaurantModelMock = new RestaurantModel(1L
                ,"fffutf"
                ,"1231234t"
                ,"sdfgn"
                ,"sdfgh"
                ,"123456"
                ,2L);


        Assertions.assertThrows(NoDataFoundException.class,
                () -> restaurantUseCaseMock.saveRestaurant(restaurantModelMock));
    }

    @Test
    @DisplayName("PhoneError")
    void saveRestaurantPhoneError() {
        RestaurantModel restaurantModelMock = new RestaurantModel(1L
                ,"fffutf"
                ,"1231234"
                ,"sdfgn"
                ,"sdfgh"
                ,"1234565677777777"
                ,2L);


        Assertions.assertThrows(NoDataFoundException.class,
                () -> restaurantUseCaseMock.saveRestaurant(restaurantModelMock));
    }

    @Test
    @DisplayName("NameError")
    void saveRestaurantNameError() {
        RestaurantModel restaurantModelMock = new RestaurantModel(1L
                ,"12345"
                ,"1231234"
                ,"sdfgn"
                ,"sdfgh"
                ,"1234565677777777"
                ,2L);


        Assertions.assertThrows(NoDataFoundException.class,
                () -> restaurantUseCaseMock.saveRestaurant(restaurantModelMock));
    }

    @Test
    void getAllRestaurants() {
        RestaurantModel restaurantModelMock = new RestaurantModel(1L
                ,"fffutf"
                ,"1231234t"
                ,"sdfgn"
                ,"sdfgh"
                ,"123456"
                ,2L);

        Mockito.when(restaurantPersistencePortMock.getAllRestaurants())
                .thenReturn(List.of(restaurantModelMock));

        var restaurant = restaurantUseCaseMock.getAllRestaurants();

        Assertions.assertEquals(1L,restaurant.get(0).getIdRestaurant());
    }


    @Test
    void getAllRestaurantsIsEmpty() {

        Mockito.when(restaurantPersistencePortMock.getAllRestaurants())
                .thenReturn(Collections.emptyList());

        Assertions.assertThrows(NoDataFoundException.class,
                () -> restaurantUseCaseMock.getAllRestaurants());
    }
}
