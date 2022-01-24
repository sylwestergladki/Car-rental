package io.github.sylwestergladki.carrental.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Getter
@ToString
@EqualsAndHashCode
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

}
