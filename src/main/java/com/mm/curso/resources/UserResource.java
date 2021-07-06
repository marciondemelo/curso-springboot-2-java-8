package com.mm.curso.resources;

import com.mm.curso.entiities.User;
import com.mm.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController //Necessario informar que a classe é um recurso wer implementado por um recurso rest/
@RequestMapping(value = "/usuarios") //Necessario dar um nome para o meu recurso. Controlador Rest que responde ao caminho usuarios/
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){ /*Um método para acessar os usuários (Apenas teste). ResponseEntity é especifico do spring
para retornar requisições web*/

        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = userService.findBuId(id);
        return ResponseEntity.ok().body(obj);
    }
}
