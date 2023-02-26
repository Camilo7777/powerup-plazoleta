package com.pragma.powerup.application.dto.response;

import com.pragma.powerup.domain.model.RestaurantModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishResponseDto {

    private String id;

    private String name;

    private Integer price;

    private String description;

    private String url;

    private Long idCategory;

    private Boolean active;

    private Long restaurantId;
}
