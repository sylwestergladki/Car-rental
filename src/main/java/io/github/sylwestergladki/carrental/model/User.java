package io.github.sylwestergladki.carrental.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "User's name must not be empty")
    private String name;
    @NotBlank(message = "User's surename must not be empty")
    private String surename;

    public User(String name, String surename) {
        this.name = name;
        this.surename = surename;
    }
}
