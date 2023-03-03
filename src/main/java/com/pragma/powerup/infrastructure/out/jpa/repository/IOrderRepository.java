package com.pragma.powerup.infrastructure.out.jpa.repository;

import com.pragma.powerup.infrastructure.out.jpa.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface IOrderRepository extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> findByStatus(String status);
    Optional<OrderEntity> findByIdClient(Long id);

}
