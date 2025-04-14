package com.Mahmoud.Karate.System.Entities;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany(mappedBy = "players")
    private List<Session> sessions = new ArrayList<>();

    @OneToMany(mappedBy = "player" , cascade = CascadeType.ALL)
    private List<BeltDetails> beltDetails = new ArrayList<>();
}
