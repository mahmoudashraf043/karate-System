package com.Mahmoud.Karate.System.Entities;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "player")
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first name")
    private String firstName;

    @Column(name = "middle name")
    private String middleName;

    @Column(name = "last name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "age")
    private int age;

    @Column(name = "join date")
    private LocalDate joinDate;
}
