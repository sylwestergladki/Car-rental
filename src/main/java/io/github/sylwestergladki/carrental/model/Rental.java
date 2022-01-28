package io.github.sylwestergladki.carrental.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Car car;

    @ManyToOne
    private User user;

    private boolean active;

    private ZonedDateTime startDate;

    public void endRental() {
        this.active = false;
    }

    public Rental(Car car, User user) {
        this.car = car;
        this.user = user;
        this.active = true;
        this.startDate = ZonedDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return car.equals(rental.car) && user.equals(rental.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, user);
    }
}
