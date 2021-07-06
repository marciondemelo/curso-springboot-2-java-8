package com.mm.curso.resources;

import com.mm.curso.entiities.Order;
import com.mm.curso.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController //Necessario informar que a classe é um recurso wer implementado por um recurso rest/
@RequestMapping(value = "/orders") //Necessario dar um nome para o meu recurso. Controlador Rest que responde ao caminho usuarios/
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){

        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = orderService.findBuId(id);
        return ResponseEntity.ok().body(obj);
    }
}