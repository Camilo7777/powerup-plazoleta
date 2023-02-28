package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.DishResquestDto;
import com.pragma.powerup.application.dto.request.UserRequestDto;
import com.pragma.powerup.application.dto.response.DishResponseDto;
import com.pragma.powerup.application.handler.IDishHandler;
import com.pragma.powerup.infrastructure.resttemplate.RestTemplateRestaurant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dish")
@RequiredArgsConstructor
public class DishRestController {

    private final IDishHandler dishHandler;

    private final RestTemplateRestaurant restTemplateRestaurant;

    @Operation(summary = "Save a plate by verifying that its id has the role of owner")
    @PostMapping("/saveDish")
    public ResponseEntity<Void> saveDish(@RequestBody DishResquestDto dishResquestDto) {
        // restTemplateRestaurant.userOwnerAuthorizedDish(dishResquestDto.getId());
        dishHandler.saveDish(dishResquestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Update a plate according to its id")
    @PutMapping("/updateDish")
    public ResponseEntity<Void> updateDish(@RequestBody DishResquestDto dishResquestDto) {
        // restTemplateRestaurant.userOwnerAuthorizedDish(dishResquestDto.getId());
        dishHandler.updateDish(dishResquestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "enable - disable dish")
    @PutMapping("/enableDisableDish/{dishId}")
    public ResponseEntity<Void> enableDisableDish(@PathVariable Long dishId) {
        // restTemplateRestaurant.userOwnerAuthorizedDish(dishResquestDto.getId());
        dishHandler.enableDisableDish(dishId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "list dishes from each restaurant")
    @GetMapping("/{id}")
    public ResponseEntity<List<DishResponseDto>> getByIdRestaurant(@Parameter(name = "Id tipo Long") @PathVariable Long id) {
        return ResponseEntity.ok(dishHandler.findByRestaurantId(id));
    }

}