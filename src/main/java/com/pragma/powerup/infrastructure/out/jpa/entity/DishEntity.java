package com.pragma.powerup.infrastructure.out.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "dish")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DishEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_dish")
    private Long id;
    private String name;

    private Integer price;

    private String description;

    private String url;

    @Column(name = "id_category")
    private Long idCategory;

    private Boolean active;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    @OneToMany(fetch =FetchType.LAZY,mappedBy = "dishEntity",cascade = CascadeType.ALL)
    private List<OrderDishEntity> orderDishEntities;


}
