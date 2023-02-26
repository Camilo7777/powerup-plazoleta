package com.pragma.powerup.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class RestaurantResquestDto {
    private Long idRestaurant;
    private String name;

    private String nit;
    private String address;

    private String url;

    private String phone;

    private Long idUser;
}
