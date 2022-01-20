package io.github.sylwestergladki.carrental.controller;


import io.github.sylwestergladki.carrental.model.Car;
import io.github.sylwestergladki.carrental.repository.CarRepository;
import io.github.sylwestergladki.carrental.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);
    private final CarRepository repository;
    private final CarService service;


    CarController(CarRepository repository, CarService service){
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<Car>> readAllTasks(){
        return ResponseEntity.ok(service.readAll());
    }

    @PostMapping
    ResponseEntity<Car> createCar(@RequestBody @Valid Car carToSave){
        Car result = service.save(carToSave);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }




}
