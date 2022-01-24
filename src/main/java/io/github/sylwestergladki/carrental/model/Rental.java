package io.github.sylwestergladki.carrental.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@AllArgsConstructor
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

    private boolean isActive;

    private ZonedDateTime startDate;

    public void endRental() {
        this.isActive = false;
    }

    public Rental() {
    }


}
