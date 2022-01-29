package io.github.sylwestergladki.carrental.controller;


import io.github.sylwestergladki.carrental.model.Car;
import io.github.sylwestergladki.carrental.service.CarService;
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
        return ResponseEntity.ok(service.readAllCars());
    }

    @PostMapping
    ResponseEntity<Car> createCar(@RequestBody @Valid Car carToSave){
        Car result = service.addCar(carToSave);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getCar(@PathVariable int id){
        return service.findCar(id).map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateCar(@PathVariable int id, @RequestBody @Valid Car toUpdate){
        if(!service.existsCar(id)){
            return ResponseEntity.notFound().build();
        }
        service.findCar(id).ifPresent(car -> {
            car.updateFrom(toUpdate);
            service.addCar(car);
        });
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteCar(@PathVariable int id){
        if(service.findCar(id).isPresent()){
            service.deleteCar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
