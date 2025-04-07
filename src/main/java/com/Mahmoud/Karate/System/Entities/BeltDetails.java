package com.Mahmoud.Karate.System.Entities;

import com.Mahmoud.Karate.System.Enum.Beltdegree;
import jakarta.persistence.*;

@Entity
@Table(name = "Belt Details")
public class BeltDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "degree")
    @Enumerated(EnumType.STRING)
    private Beltdegree beltdegree;


}
