package com.pragma.powerup.infrastructure.out.jpa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class OrderEntity {
    @Id
    @Column(name = "id_order")
    private Long idOrder;
    @Column(name = "id_client")
    private Long idClient;
    private Date date;
    private String status;
    @Column(name = "id_chef")
    private Long idChef;
    @Column(name = "id_restaurant")
    private Long idRestaurant;

    @OneToMany(mappedBy = "idOrder")
    private List<OrderDishEntity> orderDishEntityList;

}
