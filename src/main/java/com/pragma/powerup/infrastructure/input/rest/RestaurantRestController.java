package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.RestaurantResquestDto;
import com.pragma.powerup.application.dto.request.UserRequestDto;
import com.pragma.powerup.application.dto.response.RestaurantResponseDto;
import com.pragma.powerup.application.handler.IRestaurantHandler;
import com.pragma.powerup.infrastructure.feign.UserFeignClient;
import com.pragma.powerup.infrastructure.resttemplate.RestTemplateRestaurant;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantRestController {

    private final UserFeignClient userFeignClient;

    private final IRestaurantHandler restaurantHandler;
    private final RestTemplateRestaurant restTemplateRestaurant;

    @Operation(summary = "Save a restaurant verifying that its id has the administrator role")
    @PostMapping("/saveRestaurant")
    public ResponseEntity<Void> saveRestaurant(@RequestBody RestaurantResquestDto restaurantResquestDto) {
        //restTemplateRestaurant.userOwnerAuthorized(restaurantResquestDto.getIdUser());
        restaurantHandler.saveRestaurant(restaurantResquestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get a list of restaurants")
    @GetMapping("/getAll")
    public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantHandler.getAllRestaurants());
    }

    @GetMapping("/prueba/{id}")
    public String getById(@PathVariable Long id) {
        UserRequestDto userRequestDto = userFeignClient.getById(id);
        return userRequestDto.getFistName() + userRequestDto.getEmail();
    }
}
