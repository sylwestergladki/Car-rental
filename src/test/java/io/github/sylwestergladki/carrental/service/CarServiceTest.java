package io.github.sylwestergladki.carrental.service;

import io.github.sylwestergladki.carrental.model.Car;
import io.github.sylwestergladki.carrental.model.FuelType;
import io.github.sylwestergladki.carrental.repository.CarRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CarServiceTest {



    @Test
    void should_return_a_list_of_cars(){
        //given
        CarRepository repository = mock(CarRepository.class);
        CarService service = new CarService(repository);
        //when
        var result = service.readAll();
        //then
        assertThat(result).asList();
    }

    @Test
    void should_add_one_car_to_list(){
        //given
        CarRepository repository = mock(CarRepository.class);
        CarService service = new CarService(repository);
        repository.save(new Car("AUDI","A4","black", FuelType.DIESEL));
        //when
        var result = service.readAll();
        //then
        assertThat(result).asList();
    }
}