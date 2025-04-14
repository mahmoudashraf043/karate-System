package com.Mahmoud.Karate.System.Entities;

import com.Mahmoud.Karate.System.Enum.Beltdegree;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Belt_Details")
@Data
public class BeltDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "degree")
    @Enumerated(EnumType.STRING)
    private Beltdegree beltdegree;

    @Column(name = "belt_date ")
    private LocalDate beltDate;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;


}
