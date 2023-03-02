package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IDishServicePort;
import com.pragma.powerup.domain.exception.WrongDataException;
import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.spi.IDishPersistencePort;

import java.util.*;

import static java.util.stream.Collectors.*;

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

    @Override
    public List<DishModel> findByRestaurantId(Long id,Integer pages) {
        List<DishModel> dishModelList  = persistencePort.findByRestaurantId(id,pages);
        return  dishModelList.stream().sorted(Comparator.comparing(DishModel::getIdCategory)).collect(toList());
    }
    private void priceVerify(Integer price) {
        if (price <= 0) {
            throw new WrongDataException();
        }
    }
}
