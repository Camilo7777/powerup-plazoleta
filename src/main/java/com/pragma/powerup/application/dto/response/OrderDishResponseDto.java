package com.pragma.powerup.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderDishResponseDto {

    private Long idOrder;
    private Long idDish;
    private Long quantity;

}
