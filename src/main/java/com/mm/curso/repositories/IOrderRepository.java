package com.mm.curso.repositories;

import com.mm.curso.entiities.Order;
import com.mm.curso.entiities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
