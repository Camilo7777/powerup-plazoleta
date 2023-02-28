package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.exception.WrongDataException;
import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.spi.IDishPersistencePort;
import com.pragma.powerup.infrastructure.out.jpa.entity.DishEntity;
import com.pragma.powerup.infrastructure.out.jpa.entity.RestaurantEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IDishEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IDishRepository;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DishJpaAdapter implements IDishPersistencePort {
    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;
    @Autowired
    private IRestaurantRepository restaurantRepository;


    @Override
    public void saveDish(DishModel dishModel) {
        Optional<RestaurantEntity> restaurantModel = restaurantRepository.findById(dishModel.getRestaurantId());
        if (restaurantModel.isPresent()) {
            dishRepository.save(dishEntityMapper.toEntity(dishModel));
        } else {
            throw new WrongDataException();
        }
    }

    @Override
    public DishModel findById(Long id) {
        Optional<DishEntity> dishEntity = dishRepository.findById(id);
        if (dishEntity.isPresent()) {
            return dishEntityMapper.toDishModel(dishEntity.get());
        }
        throw new WrongDataException();
    }

    @Override
    public void enableDisableDish(Long dishId) {
        Optional<DishEntity> dishEntity = dishRepository.findById(dishId);
        dishEntity.ifPresent(entity -> entity.setActive(!entity.getActive()));
    }

    @Override
    public List<DishModel> findByRestaurantId(Long id) {
        List<DishEntity> dishEntityList = dishRepository.findByRestaurantId(id);
        if (dishEntityList.size()> 0 ){
            return dishEntityMapper.tolistModel(dishEntityList);
        }
        throw new WrongDataException();
    }

}
