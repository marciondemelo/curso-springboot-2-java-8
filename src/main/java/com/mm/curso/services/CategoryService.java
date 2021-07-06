package com.mm.curso.services;

import com.mm.curso.entiities.Category;
import com.mm.curso.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findBuId(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
}
