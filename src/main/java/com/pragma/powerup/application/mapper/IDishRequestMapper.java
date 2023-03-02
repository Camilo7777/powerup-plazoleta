package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.request.DishResquestDto;
import com.pragma.powerup.domain.model.DishModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishRequestMapper {

    DishModel toResponse(DishResquestDto dishResquestDto);

    List<DishModel> toResponseList(List<DishResquestDto> dishResquestDtoList);
}
