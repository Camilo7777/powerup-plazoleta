package com.pragma.powerup.infrastructure.feign;

import com.pragma.powerup.application.dto.request.UserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-user",url = "http://localhost:8081/user")
public interface UserFeignClient {
    @GetMapping("/{id}")
    public UserRequestDto getById(@PathVariable Long id);

    @GetMapping("/email/{email}")
    public UserRequestDto getByEmail(@PathVariable String email);

}
