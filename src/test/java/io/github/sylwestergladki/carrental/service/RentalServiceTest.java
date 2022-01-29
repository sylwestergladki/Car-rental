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

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RentalServiceTest {
    CarRepository carRepository = mock(CarRepository.class);
    UserRepository userRepository = mock(UserRepository.class);
    RentalRepository rentalRepository = mock(RentalRepository.class);
    RentalService service = new RentalService(rentalRepository,carRepository,userRepository);
    Car car = new Car(1,"VW","Polo","Black", FuelType.DIESEL);
    User user = new User(1,"Paul","Adams");

    @Test
    public void should_throw_IllegalArgumentException_when_car_does_not_exist(){
        //given
        Optional<Car> cars = Optional.empty();
        Optional<User> users = Optional.of(user);
        when(carRepository.findById(anyInt())).thenReturn(cars);
        when(userRepository.findById(anyInt())).thenReturn(users);
        //when
        var exception = catchThrowable(()->service.addRental(new AddRentalCommand(1,1)));
        //then
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Car");
    }

    @Test
    public void should_throw_IllegalArgumentException_when_user_does_not_exist(){
        //given
        Optional<User> users = Optional.empty();
        Optional<Car> cars = Optional.of(car);
        when(carRepository.findById(anyInt())).thenReturn(cars);
        when(userRepository.findById(anyInt())).thenReturn(users);
        //when
        var exception = catchThrowable(()->service.addRental(new AddRentalCommand(1,1)));
        //then
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("User");
    }

    @Test
    public void should_throw_IllegalStateException_when_car_is_rent_by_someone_else(){
        //given
        Rental rental = new Rental(car,user);

        Optional<User> users = Optional.of(user);
        Optional<Car> cars = Optional.of(car);
        List<Rental> rentals = List.of(rental);

        when(carRepository.findById(anyInt())).thenReturn(cars);
        when(userRepository.findById(anyInt())).thenReturn(users);
        when(rentalRepository.getByActiveIsTrueAndCar_Id(anyInt())).thenReturn(rentals);

        //when
        var exception = catchThrowable(()->service.addRental(new AddRentalCommand(1,1)));

        //then
        assertThat(exception)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("car is current rent");
    }


}

