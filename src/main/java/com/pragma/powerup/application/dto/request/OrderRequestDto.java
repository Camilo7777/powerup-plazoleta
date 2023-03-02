package com.pragma.powerup.application.dto.request;

import com.pragma.powerup.infrastructure.out.jpa.entity.OrderDishEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderRequestDto {

    private Long idOrder;

    private Long idClient;
    private Date date;
    private String status;

    private Long idChef;


    private Long idRestaurant;

    private List<OrderDishEntity> orderDishEntities;


}
