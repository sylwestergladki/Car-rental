package io.github.sylwestergladki.carrental.service;


import io.github.sylwestergladki.carrental.model.Car;
import io.github.sylwestergladki.carrental.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public List<Car> readAllCars(){
        return repository.findAll();
    }

    public Car addCar(Car carToSave){
        return repository.save(carToSave);
    }

    public Optional<Car> findCar(int id){
        return repository.findById(id);
    }

     public void deleteCar(int id){
      repository.deleteById(id);
    }
    public boolean existsCar(int id){
        return repository.existsById(id);
    };

}
