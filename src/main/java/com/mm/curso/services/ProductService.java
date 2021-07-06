package com.mm.curso.services;

import com.mm.curso.entiities.Product;
import com.mm.curso.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findBuId(Long id){
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }
}
