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
        if (userRequestDto == null) {
            throw new UsernameNotFoundException("Username Not Found");
        }
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority(verifyRole(userRequestDto.getRoleId())));
            return new User(userRequestDto.getEmail(), userRequestDto.getPassword(), authorities);
        }
    private String verifyRole(Long id) {
        String rol;
        if (id == 1) {
            return "ADMIN";
        } else if (id == 2) {
            return "OWNER";
        } else if (id == 3) {
            return "EMPLOYEE";
        } else {
            return "CLIENT";
        }
    }
}
