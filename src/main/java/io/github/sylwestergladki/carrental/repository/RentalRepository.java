package io.github.sylwestergladki.carrental.repository;

import io.github.sylwestergladki.carrental.model.Rental;

import java.util.List;
import java.util.Optional;

public interface RentalRepository {
    List<Rental> findAll();

    Optional<Rental> findById(Integer i);

    Rental save(Rental entity);

    void deleteById(Integer id);

    List<Rental> getByActiveIsTrueAndCar_Id(int carId);
}
