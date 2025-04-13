package com.Mahmoud.Karate.System.Entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "session")
@Data
public class Session {
    @id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    int id;

    @Column(name = "title")
    String title;

    @Column(name = "notes")
    String notes;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany
    @JoinTable(
            name = "session_players",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> players = new ArrayList<>();
}
