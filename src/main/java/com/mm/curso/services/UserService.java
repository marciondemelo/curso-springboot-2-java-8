package com.mm.curso.services;

import com.mm.curso.entiities.User;
import com.mm.curso.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User update(Long id, User user){
        User obj = userRepository.getById(id);

        mapUser(user, obj);
        return userRepository.save(obj);
    }

    private void mapUser(User user, User obj) {
        obj.setName(user.getName());
        obj.setEmail(user.getEmail());
        obj.setPhone(user.getPhone());
        obj.setPassword(user.getPassword());
    }
}
