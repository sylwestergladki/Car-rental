package io.github.sylwestergladki.carrental.service;


import io.github.sylwestergladki.carrental.model.Car;
import io.github.sylwestergladki.carrental.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public List<Car> readAll(){
        return repository.findAll();
    }
}
