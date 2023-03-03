package com.pragma.powerup.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderDishResquestDto {
    private Long idOrder;
    private Long idDish;
    private Long quantity;

}
