package io.github.sylwestergladki.carrental.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
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




}
