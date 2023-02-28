package com.pragma.powerup.security;

import com.pragma.powerup.application.dto.request.UserRequestDto;
import com.pragma.powerup.infrastructure.feign.UserFeignClient;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class RegisterUserDetailsService implements UserDetailsService {

    private final UserFeignClient userFeignClient;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRequestDto userRequestDto = userFeignClient.getByEmail(username);
        String rol;
        if (userRequestDto.getRoleId() == 1){
            rol = "ADMIN";
        }else if (userRequestDto.getRoleId() == 2){
            rol = "OWNER";
        }else if (userRequestDto.getRoleId() == 3){
            rol = "EMPLOYEE";
        }else{
            rol = "CLIENT";
        }
        if (userRequestDto == null) {
            throw new UsernameNotFoundException("Username Not Found");
        }
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority(rol));
            return new User(userRequestDto.getEmail(), userRequestDto.getPassword(), authorities);
    }


}
