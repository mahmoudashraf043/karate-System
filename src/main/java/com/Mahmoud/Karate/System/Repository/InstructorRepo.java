package com.Mahmoud.Karate.System.Repository;

import com.Mahmoud.Karate.System.Entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Integer> {

     Optional<Instructor> findByUserName(String userName);
}
