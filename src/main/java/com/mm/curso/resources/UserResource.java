package com.mm.curso.resources;

import com.mm.curso.entiities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController //Necessario informar que a classe é um recurso wer implementado por um recurso rest/
@RequestMapping(value = "/usuarios") //Necessario dar um nome para o meu recurso. Controlador Rest que responde ao caminho usuarios/
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){ /*Um método para acessar os usuários (Apenas teste). ResponseEntity é especifico do spring
para retornar requisições web*/

        User u = new User(1L, "Davidson", "davidson@", "7777-7777", "12345"); /*instanciando o meu usuario com meu construtor*/
        return ResponseEntity.ok().body(u);
    }
}
