package com.mm.curso.repositories;

import com.mm.curso.entiities.OrderItem;
import com.mm.curso.entiities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Long> {
}
