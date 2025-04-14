package com.Mahmoud.Karate.System.Repository;

import com.Mahmoud.Karate.System.Entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo  extends JpaRepository<Player,Integer> {
}
