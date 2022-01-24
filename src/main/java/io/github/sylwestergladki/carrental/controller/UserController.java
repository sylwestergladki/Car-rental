package io.github.sylwestergladki.carrental.controller;


import io.github.sylwestergladki.carrental.model.Car;
import io.github.sylwestergladki.carrental.model.User;
import io.github.sylwestergladki.carrental.repository.CarRepository;
import io.github.sylwestergladki.carrental.service.CarService;
import io.github.sylwestergladki.carrental.service.UserService;
import org.apache.catalina.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;


    UserController(UserService service){
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<User>> readAllUsers(){
        return ResponseEntity.ok(service.readAll());
    }

    @PostMapping
    ResponseEntity<User> saveUser(@RequestBody @Valid User userToSave){
        User result = service.save(userToSave);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getUser(@PathVariable int id){
        return service.findById(id).map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable int id){
        if(service.findById(id).isPresent()){
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
