package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.application.dto.request.DishResquestDto;
import com.pragma.powerup.domain.exception.WrongDataException;
import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.DishEntity;
import com.pragma.powerup.infrastructure.out.jpa.entity.RestaurantEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IDishEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IDishRepository;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRestaurantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(SpringExtension.class)
class DishJpaAdapterTest {
    @Mock
    private  IDishRepository dishRepositoryMock;
    @Mock
    private  IDishEntityMapper dishEntityMapperMock;
    @Mock
    private  IRestaurantRepository restaurantRepositoryMock;
    @InjectMocks
    private DishJpaAdapter dishJpaAdapterMock;

    @Test
    void saveDish() {
        DishModel dishModelMock = new DishModel(
                1L,"pez",3000,"bueno",
                "dddff",2L,true,1L);

        DishResquestDto dishResquestDtoMock = DishResquestDto.builder()
                .id(1L)
                .price(3000)
                .url("ertgh")
                .active(true)
                .description("Es bueno")
                .idCategory(2L)
                .name("Pez")
                .restaurantId(1L)
                .build();

        DishEntity dishEntityMock = DishEntity.builder()
                .id(1L)
                .name("jugo")
                .price(3000)
                .description("bueno")
                .url("dwdwfw")
                .restaurantId(1L)
                .idCategory(1L)
                .build();

        RestaurantEntity restaurantEntityMock =
                new RestaurantEntity(1L,"pepe","1234","ddfef","34dff"
                        ,"2345",2L);

      Mockito.when(restaurantRepositoryMock.findById(1L))
                      .thenReturn(Optional.of(restaurantEntityMock));

      Mockito.when(dishEntityMapperMock.toEntity(dishModelMock))
                      .thenReturn(dishEntityMock);

        dishJpaAdapterMock.saveDish(dishModelMock);

        Mockito.verify(dishRepositoryMock, Mockito.times(1))
                .save(dishEntityMock);

    }


    @Test
    void saveDishRestaurantNOExist() {
        DishModel dishModelMock = new DishModel(
                1L,"pez",3000,"bueno",
                "dddff",2L,true,1L);

        DishResquestDto dishResquestDtoMock = DishResquestDto.builder()
                .id(1L)
                .price(3000)
                .url("ertgh")
                .active(true)
                .description("Es bueno")
                .idCategory(2L)
                .name("Pez")
                .restaurantId(1L)
                .build();

        DishEntity dishEntityMock = DishEntity.builder()
                .id(1L)
                .name("jugo")
                .price(3000)
                .description("bueno")
                .url("dwdwfw")
                .restaurantId(1L)
                .idCategory(1L)
                .build();

        RestaurantEntity restaurantEntityMock =
                new RestaurantEntity(1L,"pepe","1234","ddfef","34dff"
                        ,"2345",2L);

        Mockito.when(restaurantRepositoryMock.findById(2L))
                .thenReturn(Optional.of(restaurantEntityMock));

        Mockito.when(dishEntityMapperMock.toEntity(dishModelMock))
                .thenReturn(dishEntityMock);

        Assertions.assertThrows(WrongDataException.class,
                ()-> dishJpaAdapterMock.saveDish(dishModelMock));

    }

    @Test
    void findById() {
        DishEntity dishEntityMock = DishEntity.builder()
                .id(1L)
                .name("jugo")
                .price(3000)
                .description("bueno")
                .url("dwdwfw")
                .restaurantId(5L)
                .idCategory(1L)
                .build();

        DishModel dishModelMock = new DishModel(
                1L,"pez",3000,"bueno",
                "dddff",2L,true,2L);

        Mockito.when(dishRepositoryMock.findById(anyLong()))
                .thenReturn(Optional.of(dishEntityMock));

        Mockito.when(dishEntityMapperMock.toDishModel(any()))
                .thenReturn(dishModelMock);

      DishModel dishModel =  dishJpaAdapterMock.findById(1L);

        Assertions.assertEquals(1L,dishModel.getId());
    }


    @Test
    void findByIdIsEmpty() {
        DishEntity dishEntityMock = DishEntity.builder()
                .id(1L)
                .name("jugo")
                .price(3000)
                .description("bueno")
                .url("dwdwfw")
                .restaurantId(5L)
                .idCategory(1L)
                .build();

        DishModel dishModelMock = new DishModel(
                1L,"pez",3000,"bueno",
                "dddff",2L,true,2L);

        Mockito.when(dishRepositoryMock.findById(anyLong()))
                .thenReturn(Optional.empty());


       Assertions.assertThrows(WrongDataException.class,
               () -> dishJpaAdapterMock.findById(anyLong()));
    }

    @Test
    void enableDisableDish() {
        DishEntity dishEntityMock = DishEntity.builder()
                .id(1L)
                .name("jugo")
                .price(3000)
                .description("bueno")
                .url("dwdwfw")
                .restaurantId(5L)
                .active(false)
                .idCategory(1L)
                .build();

        DishModel dishModelMock = new DishModel(
                1L,"pez",3000,"bueno",
                "dddff",2L,true,1L);

        Mockito.when(dishRepositoryMock.findById(1L))
                .thenReturn(Optional.of(dishEntityMock));


        Mockito.verify(dishJpaAdapterMock, Mockito.times(1))
                .enableDisableDish(1L);

    }

}