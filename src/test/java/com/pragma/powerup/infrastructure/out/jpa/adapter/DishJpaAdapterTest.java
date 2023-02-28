package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.exception.WrongDataException;
import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.DishEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IDishEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IDishRepository;
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

    @InjectMocks
    private DishJpaAdapter dishJpaAdapterMock;

    @Test
    void saveDish() {

    }

    @Test
    void findById() {

        DishEntity dishEntityMock = new DishEntity(1L,"jugo",3000,"bueno",
                "dwdwfw",1L,true,5L);

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

        DishEntity dishEntityMock = new DishEntity(1L,"jugo",3000,"bueno",
                "dwdwfw",1L,true,5L);

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
        DishEntity dishEntityMock = new DishEntity(1L,"jugo",3000,"bueno",
                "dwdwfw",1L,true,5L);

        DishModel dishModelMock = new DishModel(
                1L,"pez",3000,"bueno",
                "dddff",2L,true,2L);

        Mockito.when(dishRepositoryMock.findById(anyLong()))
                .thenReturn(Optional.of(dishEntityMock));

    }
}