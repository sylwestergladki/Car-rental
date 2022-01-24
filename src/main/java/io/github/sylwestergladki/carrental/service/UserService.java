package io.github.sylwestergladki.carrental.service;



import io.github.sylwestergladki.carrental.model.User;
import io.github.sylwestergladki.carrental.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> readAll(){
        return repository.findAll();
    }

    public User save(User userToSave){
        return repository.save(userToSave);
    }

    public Optional<User> findById(int id){
        return repository.findById(id);
    }

     public void delete(int id){
      repository.deleteById(id);
    }
}
