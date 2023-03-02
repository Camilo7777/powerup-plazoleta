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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;

import java.util.Optional;

@RequiredArgsConstructor
public class DishJpaAdapter implements IDishPersistencePort {
    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;

    private final  IRestaurantRepository restaurantRepository;

    @Override
    public void saveDish(DishModel dishModel) {
        Optional<RestaurantEntity> restaurantEntity= restaurantRepository.findById(dishModel.getRestaurantId());
        if (restaurantEntity.isPresent()) {
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
        if (dishEntity.isPresent()){
            dishEntity.get().setActive(!dishEntity.get().getActive());
        }else{
            throw new WrongDataException();
        }
    }

    @Override
    public List<DishModel> findByRestaurantId(Long id,Integer pages) {
        Pageable sortedByName =
                PageRequest.of(0,  pages);
        List<DishEntity> dishEntityList = dishRepository.findByRestaurantId(id,sortedByName);
        if (!dishEntityList.isEmpty() ){
            return dishEntityMapper.tolistModel(dishEntityList);
        }
        throw new WrongDataException();
    }


}
