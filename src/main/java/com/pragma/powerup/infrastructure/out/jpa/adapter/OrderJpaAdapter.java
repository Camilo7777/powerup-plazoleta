package com.pragma.powerup.infrastructure.out.jpa.adapter;


import com.pragma.powerup.domain.exception.WrongDataException;
import com.pragma.powerup.domain.model.OrderModel;
import com.pragma.powerup.domain.spi.IOrderPersistencePort;
import com.pragma.powerup.infrastructure.out.jpa.entity.OrderEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IOrderEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IOrderDishRepository;
import com.pragma.powerup.infrastructure.out.jpa.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class OrderJpaAdapter implements IOrderPersistencePort {
    private final IOrderRepository orderRepository;
    private final IOrderEntityMapper orderEntityMapper;

    private final IOrderDishRepository orderDishRepository;
    @Override
    public void saveOrder(OrderModel orderModel) {
      Optional<OrderEntity> orderEntity = orderRepository.findByIdClient(orderModel.getIdClient());
      if (orderEntity.isEmpty()) {
          orderRepository.save(orderEntityMapper.toEntity(orderModel));
          orderModel.getOrderDishEntityList().forEach(orderDish -> {
              orderDishRepository.save(orderDish);
          });
      }else{
          throw new WrongDataException();
      }
    }

    @Override
    public List<OrderModel> findByStatus(String status) {
        return orderEntityMapper.tolistModel(orderRepository.findByStatus(status));
    }
}
