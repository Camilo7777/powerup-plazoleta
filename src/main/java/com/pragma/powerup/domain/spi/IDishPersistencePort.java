package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.DishModel;
public interface IDishPersistencePort {

    void saveDish(DishModel dishModel);

    DishModel findById(Long id);

    void enableDisableDish(Long dishId);
}
