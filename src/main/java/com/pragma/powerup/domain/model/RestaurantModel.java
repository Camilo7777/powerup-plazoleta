package com.pragma.powerup.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantModel {
    private Long idRestaurant;
    private String name;

    private String nit;
    private String address;

    private String url;

    private String phone;

    private Long idUser;

}
