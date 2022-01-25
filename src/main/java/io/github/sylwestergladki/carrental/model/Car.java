package io.github.sylwestergladki.carrental.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Car's model must not be empty")
    private String model;
    @NotBlank(message = "Car's brand must not be empty")
    private String brand;
    @NotBlank(message = "Car's color must not be empty")
    private String color;
    private FuelType fuelType;






}
