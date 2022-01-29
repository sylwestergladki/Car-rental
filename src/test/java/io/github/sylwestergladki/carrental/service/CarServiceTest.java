package io.github.sylwestergladki.carrental.service;

import io.github.sylwestergladki.carrental.model.Car;
import io.github.sylwestergladki.carrental.model.FuelType;
import io.github.sylwestergladki.carrental.repository.CarRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarServiceTest {



    @Test
    void should_return_a_list_of_cars(){
        //given
        CarRepository repository = mock(CarRepository.class);
        CarService service = new CarService(repository);
        //when
        var result = service.readAllCars();
        //then
        assertThat(result).asList();
    }

    @Test
    void should_add_one_car_to_list(){
        //given
        CarRepository repository = mock(CarRepository.class);
        CarService service = new CarService(repository);
        Car car = new Car("AUDI","A4","black", FuelType.DIESEL);
        when(repository.save(car)).thenReturn(car);

        //when
        var result = service.addCar(new Car("AUDI","A4","black", FuelType.DIESEL));
        //then
        assertThat(result).isEqualTo(car);
    }
}