package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.exception.WrongDataException;
import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.spi.IDishPersistencePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
@ExtendWith(SpringExtension.class)
class DishUseCaseTest {

    @Mock
    private IDishPersistencePort persistencePortMock;

    @InjectMocks
    private DishUseCase dishUseCaseMock;
    @Test
    void saveDish() {

        DishModel dishModelMock = new DishModel(
                1L,"pez",3000,"bueno",
                "dddff",2L,true,2L);

        dishUseCaseMock.saveDish(dishModelMock);

        Mockito.verify(persistencePortMock, Mockito.times(1))
                .saveDish(dishModelMock);

    }


    @Test
    void saveDishBadPrice() {

        DishModel dishModelMock = new DishModel(
                1L,"pez",-3000,"bueno",
                "dddff",2L,true,2L);

        Assertions.assertThrows(WrongDataException.class,
                () -> dishUseCaseMock.saveDish(dishModelMock));



    }

    @Test
    void findById() {
        DishModel dishModelMock = new DishModel(
                1L,"pez",3000,"bueno",
                "dddff",2L,true,2L);

        Mockito.when(persistencePortMock.findById(anyLong()))
                .thenReturn(dishModelMock);

        DishModel dishModel = dishUseCaseMock.findById(1L);
        Assertions.assertEquals(1L,dishModel.getId());
    }

    @Test
    void updateDish() {
        DishModel dishModelMock = new DishModel(
                1L,"pez",3000,"bueno",
                "dddff",2L,true,2L);

        Mockito.when(persistencePortMock.findById(anyLong()))
                .thenReturn(dishModelMock);

        dishUseCaseMock.updateDish(dishModelMock);

        Mockito.verify(persistencePortMock, Mockito.times(1))
                .saveDish(dishModelMock);


    }

    @Test
    void enableDisableDish() {
        dishUseCaseMock.enableDisableDish(anyLong());
        Mockito.verify(persistencePortMock, Mockito.times(1))
                .enableDisableDish(any());
    }

}