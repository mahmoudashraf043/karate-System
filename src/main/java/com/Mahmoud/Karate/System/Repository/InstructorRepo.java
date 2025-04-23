package com.Mahmoud.Karate.System.Repository;

import com.Mahmoud.Karate.System.Entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Integer> {

     Optional<Instructor> findByUserName(String userName);


    boolean existsByUsername(String username);

    boolean existsByEmail(String username);

    @Query("Delete from Instructor  i where i.username = :username")
    int deleteByUsername(@Param("username") String username);
}
