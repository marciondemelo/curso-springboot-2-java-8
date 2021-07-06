package com.mm.curso.services;

import com.mm.curso.entiities.User;
import com.mm.curso.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findBuId(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }
}
