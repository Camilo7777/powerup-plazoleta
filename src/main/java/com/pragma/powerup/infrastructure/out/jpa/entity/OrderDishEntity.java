package com.pragma.powerup.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "order_dish")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_dish")
    private Long idOrderDish;
    private Long quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order")
    private OrderEntity orderEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dish")
    private DishEntity dishEntity;

}
