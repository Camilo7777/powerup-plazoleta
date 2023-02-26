package com.pragma.powerup.infrastructure.resttemplate;

public interface RestTemplateRestaurant {
    void userAdministratorAuthorized(Long idUser);

    void userOwnerAuthorized(Long idUser);

     void userOwnerAuthorizedDish(Long idRestaurant);
}
