package io.github.sylwestergladki.carrental.controller;


import io.github.sylwestergladki.carrental.model.User;
import io.github.sylwestergladki.carrental.service.UserService;
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
        return ResponseEntity.ok(service.readAllUsers());
    }

    @PostMapping
    ResponseEntity<User> saveUser(@RequestBody @Valid User userToSave){
        User result = service.addUser(userToSave);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getUser(@PathVariable int id){
        return service.findUser(id).map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable int id){
        if(service.findUser(id).isPresent()){
            service.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
