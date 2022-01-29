package io.github.sylwestergladki.carrental.controller;


import io.github.sylwestergladki.carrental.model.Rental;
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
        return ResponseEntity.ok(service.readAllRentals());
    }

    @PostMapping
    ResponseEntity<Rental> createRental(@RequestBody @Valid AddRentalCommand rentalToSave){
        Rental result = service.addRental(rentalToSave);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Rental> deleteRental(@PathVariable int id){
        if(service.findRental(id).isPresent()){
            service.deleteRental(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }




}
