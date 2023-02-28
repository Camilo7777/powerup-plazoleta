package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.DishResquestDto;
import com.pragma.powerup.application.dto.response.DishResponseDto;
import com.pragma.powerup.application.handler.IDishHandler;
import com.pragma.powerup.application.mapper.IDishRequestMapper;
import com.pragma.powerup.application.mapper.IDishResponseMapper;
import com.pragma.powerup.domain.api.IDishServicePort;
import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.RestaurantEntity;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DishHandler implements IDishHandler {

    private final IDishServicePort servicePort;
    private final IDishRequestMapper dishRequestMapper;

    private  final IDishResponseMapper dishResponseMapper;
    @Override
    public void saveDish(DishResquestDto dishResquestDto) {

        DishModel dishModel = dishRequestMapper.toResponse(dishResquestDto);
        servicePort.saveDish(dishModel);
    }

    @Override
    public DishModel findById(Long id) {

        return servicePort.findById(id);
    }

    @Override
    public void updateDish(DishResquestDto dishResquestDto) {
        DishModel dishModel = dishRequestMapper.toResponse(dishResquestDto);
        servicePort.updateDish(dishModel);
    }

    @Override
    public void enableDisableDish(Long dishId) {

        servicePort.enableDisableDish(dishId);
    }
    @Override
    public List<DishResponseDto> findByRestaurantId(Long id) {
        List<DishModel> dishModelList = servicePort.findByRestaurantId(id);
        return dishResponseMapper.toResponseList(dishModelList);
    }
}
