package com.pragma.powerup.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantResponseDto {
    private Long idRestaurant;
    private String name;

    private String nit;
    private String address;

    private String url;
    private String phone;

    private Long idUser;
}
