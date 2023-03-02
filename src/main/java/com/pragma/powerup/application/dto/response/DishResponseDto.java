package com.pragma.powerup.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DishResponseDto {

    private Long id;

    private String name;

    private Integer price;

    private String description;

    private String url;

    private Long idCategory;

    private Boolean active;

    private Long restaurantId;
}
