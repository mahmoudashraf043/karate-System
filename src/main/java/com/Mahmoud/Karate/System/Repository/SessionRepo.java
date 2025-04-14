package com.Mahmoud.Karate.System.Repository;

import com.Mahmoud.Karate.System.Entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepo extends JpaRepository<Session,Integer> {
}
