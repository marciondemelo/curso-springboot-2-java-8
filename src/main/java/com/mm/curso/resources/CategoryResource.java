package com.mm.curso.resources;

import com.mm.curso.entiities.Category;
import com.mm.curso.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController //Necessario informar que a classe é um recurso wer implementado por um recurso rest/
@RequestMapping(value = "/categories") //Necessario dar um nome para o meu recurso. Controlador Rest que responde ao caminho usuarios/
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){

        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = categoryService.findBuId(id);
        return ResponseEntity.ok().body(obj);
    }
}