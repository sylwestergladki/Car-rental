package io.github.sylwestergladki.carrental.adapter;

import io.github.sylwestergladki.carrental.model.Rental;
import io.github.sylwestergladki.carrental.repository.RentalRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SqlRentalRepository extends RentalRepository, JpaRepository<Rental,Integer> {

   List<Rental> getByActiveIsTrueAndCar_Id(int carId);
}
