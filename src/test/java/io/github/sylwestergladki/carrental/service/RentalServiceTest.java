package io.github.sylwestergladki.carrental.service;


import io.github.sylwestergladki.carrental.model.Car;
import io.github.sylwestergladki.carrental.model.FuelType;
import io.github.sylwestergladki.carrental.model.Rental;
import io.github.sylwestergladki.carrental.model.User;
import io.github.sylwestergladki.carrental.repository.CarRepository;
import io.github.sylwestergladki.carrental.repository.RentalRepository;
import io.github.sylwestergladki.carrental.repository.UserRepository;
import io.github.sylwestergladki.carrental.service.command.AddRentalCommand;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.configuration.IMockitoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RentalServiceTest {
    CarRepository carRepository = mock(CarRepository.class);
    UserRepository userRepository = mock(UserRepository.class);
    RentalRepository rentalRepository = mock(RentalRepository.class);

    @Test
    public void should_throw_IllegalArgumentException_when_car_does_not_exist(){
        //given
        RentalService service = new RentalService(rentalRepository,carRepository,userRepository);
        Optional<Car> cars = Optional.empty();
        Optional<User> users = Optional.of(new User(1,"Paul","Adams"));
        when(carRepository.findById(anyInt())).thenReturn(cars);
        when(userRepository.findById(anyInt())).thenReturn(users);
        //when
        var exception = catchThrowable(()->service.save(new AddRentalCommand(1,1)));
        //then
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Car");
    }

    @Test
    public void should_throw_IllegalArgumentException_when_user_does_not_exist(){
        //given
        RentalService service = new RentalService(rentalRepository,carRepository,userRepository);
        Optional<User> users = Optional.empty();
        Optional<Car> cars = Optional.of(new Car(1,"VW","Polo","Black", FuelType.DIESEL));
        when(carRepository.findById(anyInt())).thenReturn(cars);
        when(userRepository.findById(anyInt())).thenReturn(users);
        //when
        var exception = catchThrowable(()->service.save(new AddRentalCommand(1,1)));
        //then
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("User");
    }


}

