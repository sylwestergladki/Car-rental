package io.github.sylwestergladki.carrental.adapter;

import io.github.sylwestergladki.carrental.model.Rental;
import io.github.sylwestergladki.carrental.model.User;
import io.github.sylwestergladki.carrental.repository.RentalRepository;
import io.github.sylwestergladki.carrental.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlRentalRepository extends RentalRepository, JpaRepository<Rental,Integer> {
}
