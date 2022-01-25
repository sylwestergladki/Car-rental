package io.github.sylwestergladki.carrental.service;


import io.github.sylwestergladki.carrental.model.Car;
import io.github.sylwestergladki.carrental.model.Rental;
import io.github.sylwestergladki.carrental.model.User;
import io.github.sylwestergladki.carrental.repository.CarRepository;
import io.github.sylwestergladki.carrental.repository.RentalRepository;
import io.github.sylwestergladki.carrental.repository.UserRepository;
import io.github.sylwestergladki.carrental.service.command.AddRentalCommand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    private RentalRepository repository;
    private CarRepository carRepository;
    private UserRepository userRepository;

    public RentalService(RentalRepository repository, CarRepository carRepository, UserRepository userRepository) {
        this.repository = repository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    public List<Rental> readAll(){
        return repository.findAll();
    }

    public Optional<Rental> findById(int id){
        return repository.findById(id);
    }

     public void delete(int id){
      repository.deleteById(id);
    }

    public Rental save(AddRentalCommand command) {
      final Car car = carRepository.findById(command.getCarId()).orElseThrow(() -> new IllegalArgumentException("Car does not exist"));
      final User user = userRepository.findById(command.getUserId()).orElseThrow(() -> new IllegalArgumentException("User does not exist"));
      List<Rental> rentals = repository.getByActiveIsTrueAndCar_Id(command.getCarId());

      if(!rentals.isEmpty()){
          throw new IllegalStateException("The car is current rent by someone else");
      }else {
          final Rental rentalToSave = new Rental(car, user);
          return repository.save(rentalToSave);
      }
    }


}
