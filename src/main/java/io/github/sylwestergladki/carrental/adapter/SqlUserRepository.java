package io.github.sylwestergladki.carrental.adapter;

import io.github.sylwestergladki.carrental.model.User;
import io.github.sylwestergladki.carrental.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlUserRepository extends UserRepository, JpaRepository<User,Integer> {
}
