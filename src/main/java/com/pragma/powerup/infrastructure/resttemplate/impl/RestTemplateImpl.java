package com.pragma.powerup.infrastructure.resttemplate.impl;

import com.pragma.powerup.application.dto.request.UserRequestDto;
import com.pragma.powerup.application.handler.IRestaurantHandler;
import com.pragma.powerup.domain.exception.WrongDataException;
import com.pragma.powerup.infrastructure.resttemplate.RestTemplateRestaurant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class RestTemplateImpl implements RestTemplateRestaurant {

    private final RestTemplate restTemplate;

   private final IRestaurantHandler restaurantHandler;

    private UserRequestDto getUser(Long idUser){
        UserRequestDto  userRequestDto= restTemplate.getForObject("http://localhost:8081/user/"+idUser,
                UserRequestDto.class);

        if (userRequestDto == null){
            throw new WrongDataException();
        }
        return userRequestDto;
    }
    @Override
    public void userAdministratorAuthorized(Long idUser) {
        UserRequestDto userRequesDto = getUser(idUser);
        Long id=0L;

        if (userRequesDto != null) {
            if (userRequesDto.getId().equals(idUser)){
                id = userRequesDto.getRoleId();
            }else{
                throw new WrongDataException();
            }
        }
        if (id != 1){
            throw new WrongDataException();
        }
    }

    @Override
    public void userOwnerAuthorized(Long idUser) {
        UserRequestDto userRequesDto = getUser(idUser);
        Long id=0L;
        if (userRequesDto != null) {
            if (userRequesDto.getId().equals(idUser)){
                id = userRequesDto.getRoleId();
            }
        }
        if (id != 2){
            throw new WrongDataException();
        }
    }

    @Override
    public void userOwnerAuthorizedDish(Long idRestaurant) {
        /*
        RestaurantResponseDto restaurantResponseDto = restaurantHandler.getAllRestaurants().stream()
                .filter(x ->x.getIdRestaurant().equals(idRestaurant))
                .findFirst().orElseThrow();

        if (restaurantResponseDto.getIdUser()>0){
            userOwnerAuthorized(restaurantResponseDto.getIdUser());
        }else{
            throw new WrongDataException();
        }

         */


    }
}
