package com.mm.curso.services;

import com.mm.curso.entiities.Order;
import com.mm.curso.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private IOrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findBuId(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}
