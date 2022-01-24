package io.github.sylwestergladki.carrental.repository;

import io.github.sylwestergladki.carrental.model.Car;
import io.github.sylwestergladki.carrental.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();

    Optional<User> findById(Integer i);

    User save(User entity);

    void deleteById(Integer id);

}
