package io.github.sylwestergladki.carrental.controller;


import io.github.sylwestergladki.carrental.model.Car;
import io.github.sylwestergladki.carrental.repository.CarRepository;
import io.github.sylwestergladki.carrental.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService service;


    CarController( CarService service){
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<Car>> readAllCars(){
        return ResponseEntity.ok(service.readAll());
    }

    @PostMapping
    ResponseEntity<Car> createCar(@RequestBody @Valid Car carToSave){
        Car result = service.save(carToSave);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getCar(@PathVariable int id){
        return service.findById(id).map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }



    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteCar(@PathVariable int id){
        if(service.findById(id).isPresent()){
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
