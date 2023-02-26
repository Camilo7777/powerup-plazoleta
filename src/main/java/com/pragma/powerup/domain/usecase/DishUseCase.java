package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IDishServicePort;
import com.pragma.powerup.domain.exception.WrongDataException;
import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.spi.IDishPersistencePort;


public class DishUseCase implements IDishServicePort {

    private final IDishPersistencePort persistencePort;



    public DishUseCase(IDishPersistencePort persistencePort) {

        this.persistencePort = persistencePort;
    }

    @Override
    public void saveDish(DishModel dishModel) {
        priceVerify(dishModel.getPrice());
        persistencePort.saveDish(dishModel);
    }

    @Override
    public DishModel findById(Long id) {
        return persistencePort.findById(id);
    }

    @Override
    public void updateDish(DishModel dishModel) {
        DishModel dishModel2 = persistencePort.findById(dishModel.getId());
        dishModel2.setPrice(dishModel.getPrice());
        dishModel2.setDescription(dishModel.getDescription());
        saveDish(dishModel2);
    }

    @Override
    public void enableDisableDish(Long dishId) {
        persistencePort.enableDisableDish(dishId);
    }

    private void priceVerify(Integer price) {
        if (price <= 0) {
            throw new WrongDataException();
        }
    }
}
