package io.github.sylwestergladki.carrental.repository;

import io.github.sylwestergladki.carrental.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    List<Car> findAll();

    Optional<Car> findById(Integer i);

    Car save(Car entity);

    void deleteById(Integer id);

    boolean existsById(Integer integer);
}
