package io.github.sylwestergladki.carrental.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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

    public Car(String model, String brand, String color, FuelType fuelType) {
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.fuelType = fuelType;
    }

    public void updateFrom(final Car source){
        this.model = source.model;
        this.brand = source.brand;
        this.color = source.color;
        this.fuelType = source.fuelType;
    }



}
