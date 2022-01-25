package io.github.sylwestergladki.carrental.controller;


import io.github.sylwestergladki.carrental.model.Car;
import io.github.sylwestergladki.carrental.model.Rental;
import io.github.sylwestergladki.carrental.model.User;
import io.github.sylwestergladki.carrental.service.CarService;
import io.github.sylwestergladki.carrental.service.RentalService;
import io.github.sylwestergladki.carrental.service.command.AddRentalCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    private final RentalService service;


    RentalController(RentalService service){
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<Rental>> readAllRentals(){
        return ResponseEntity.ok(service.readAll());
    }

    @PostMapping
    ResponseEntity<Rental> createRental(@RequestBody @Valid AddRentalCommand rentalToSave){
        Rental result = service.save(rentalToSave);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }




}
