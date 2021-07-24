package com.mm.curso.services;

import com.mm.curso.entiities.User;
import com.mm.curso.repositories.IUserRepository;
import com.mm.curso.services.exception.DatabaseException;
import com.mm.curso.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id.intValue());
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException((e.getMessage()));
        }
    }

    public User update(Long id, User user){
        try {
            User obj = userRepository.getById(id);
            mapUser(user, obj);
            return userRepository.save(obj);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void mapUser(User user, User obj) {
        obj.setName(user.getName());
        obj.setEmail(user.getEmail());
        obj.setPhone(user.getPhone());
        obj.setPassword(user.getPassword());
    }
}
