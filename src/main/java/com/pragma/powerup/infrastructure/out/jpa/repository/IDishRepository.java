package com.pragma.powerup.infrastructure.out.jpa.repository;

import com.pragma.powerup.infrastructure.out.jpa.entity.DishEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface IDishRepository extends JpaRepository<DishEntity,Long> {

    List<DishEntity> findByRestaurantId(Long id, Pageable pageable);

}
