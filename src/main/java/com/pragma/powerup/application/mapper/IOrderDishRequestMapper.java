package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.request.DishResquestDto;
import com.pragma.powerup.application.dto.request.OrderDishResquestDto;
import com.pragma.powerup.domain.model.DishModel;
import com.pragma.powerup.domain.model.OrderDishModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderDishRequestMapper {

    OrderDishModel toResponse(OrderDishResquestDto orderDishResquestDto);

    List<OrderDishModel> toResponseList(List<OrderDishResquestDto> dishResquestDtoList);
}
