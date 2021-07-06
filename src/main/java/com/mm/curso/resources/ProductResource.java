package com.mm.curso.resources;

import com.mm.curso.entiities.Product;
import com.mm.curso.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController //Necessario informar que a classe é um recurso wer implementado por um recurso rest/
@RequestMapping(value = "/products") //Necessario dar um nome para o meu recurso. Controlador Rest que responde ao caminho usuarios/
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){

        List<Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = productService.findBuId(id);
        return ResponseEntity.ok().body(obj);
    }
}