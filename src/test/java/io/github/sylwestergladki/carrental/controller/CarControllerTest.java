package io.github.sylwestergladki.carrental.controller;

import io.github.sylwestergladki.carrental.model.Car;
import io.github.sylwestergladki.carrental.model.FuelType;
import io.github.sylwestergladki.carrental.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarRepository repo;


    @Test
    void httpGet_returnAllTasks(){
        //given
        int initial = repo.findAll().size();
        repo.save(new Car("AUDI","A4","black", FuelType.DIESEL));
        repo.save(new Car("VW","Polo","black", FuelType.PETROL));

        //when
        Car[] result = restTemplate.getForObject("http://localhost:" + port + "/cars",Car[].class);

        //then
        assertThat(result).hasSize(initial + 2);
}}