package io.github.sylwestergladki.carrental.adapter;

import io.github.sylwestergladki.carrental.model.Car;
import io.github.sylwestergladki.carrental.repository.CarRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlCarRepository extends CarRepository, CrudRepository<Car,Integer> {
}
