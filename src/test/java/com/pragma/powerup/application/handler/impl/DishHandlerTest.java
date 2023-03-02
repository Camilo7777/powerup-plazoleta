package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.DishResquestDto;
import com.pragma.powerup.application.dto.response.DishResponseDto;
import com.pragma.powerup.application.mapper.IDishRequestMapper;
import com.pragma.powerup.application.mapper.IDishResponseMapper;
import com.pragma.powerup.domain.api.IDishServicePort;
import com.pragma.powerup.domain.model.DishModel;
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
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(SpringExtension.class)
class DishHandlerTest {

    @Mock
    private  IDishServicePort servicePortMock;
    @Mock
    private  IDishRequestMapper restaurantRequestMapperMock;
    @Mock
    private   IDishResponseMapper dishResponseMapper;
    @InjectMocks
    private DishHandler dishHandlerMock;

    @Test
    void saveDish() {
        DishModel dishModelMock = new DishModel(
                1L,"pez",3000,"bueno",
                "dddff",2L,true,2L);

        DishResquestDto dishResquestDtoMock = DishResquestDto.builder()
                .id(1L)
                .price(3000)
                .url("ertgh")
                .active(true)
                .description("Es bueno")
                .idCategory(2L)
                .name("Pez")
                .restaurantId(2L)
                .build();

        Mockito.when(restaurantRequestMapperMock.toResponse(any()))
                .thenReturn(dishModelMock);

        dishHandlerMock.saveDish(dishResquestDtoMock);

        Mockito.verify(servicePortMock, Mockito.times(1))
                .saveDish(dishModelMock);

    }

    @Test
    void findById() {

        DishModel dishModelMock = new DishModel(
                1L,"pez",3000,"bueno",
                "dddff",2L,true,2L);

        Mockito.when(servicePortMock.findById(anyLong()))
                .thenReturn(dishModelMock);

        DishModel dishModel = dishHandlerMock.findById(1L);
    }

    @Test
    void updateDish() {
        DishModel dishModelMock = new DishModel(
                1L,"pez",3000,"bueno",
                "dddff",2L,true,2L);

        DishResquestDto dishResquestDtoMock = DishResquestDto.builder()
                .id(1L)
                .price(3000)
                .url("ertgh")
                .active(true)
                .description("Es bueno")
                .idCategory(2L)
                .name("Pez")
                .restaurantId(2L)
                .build();

        Mockito.when(restaurantRequestMapperMock.toResponse(any()))
                .thenReturn(dishModelMock);

        dishHandlerMock.updateDish(dishResquestDtoMock);

        Mockito.verify(servicePortMock, Mockito.times(1))
                .updateDish(dishModelMock);
    }

    @Test
    void enableDisableDish() {

        dishHandlerMock.enableDisableDish(anyLong());

        Mockito.verify(servicePortMock, Mockito.times(1))
                .enableDisableDish(any());
    }

    @Test
    void findByRestaurantId() {
        DishModel dishModelMock = new DishModel(
                1L,"pez",3000,"bueno",
                "dddff",2L,true,2L);

        DishResponseDto dishResponseDto = DishResponseDto.builder()
                .id(1L)
                .price(3000)
                .url("ertgh")
                .active(true)
                .description("Es bueno")
                .idCategory(2L)
                .name("Pez")
                .restaurantId(2L)
                .build();

        Mockito.when(servicePortMock.findByRestaurantId(anyLong(),any()))
                .thenReturn(List.of(dishModelMock));

        Mockito.when(dishResponseMapper.toResponseList(List.of(dishModelMock)))
                .thenReturn(List.of(dishResponseDto));

        List<DishResponseDto> dishResponseDto2 = dishHandlerMock.findByRestaurantId(anyLong(),any());


        Assertions.assertEquals(1L,dishResponseDto2.get(0).getId());

    }
}