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

    public List<User> readAllUsers(){
        return repository.findAll();
    }

    public User addUser(User userToSave){
        return repository.save(userToSave);
    }

    public Optional<User> findUser(int id){
        return repository.findById(id);
    }

     public void deleteUser(int id){
      repository.deleteById(id);
    }
}
