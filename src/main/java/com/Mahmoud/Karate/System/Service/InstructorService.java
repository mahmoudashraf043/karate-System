package com.Mahmoud.Karate.System.Service;

import com.Mahmoud.Karate.System.Dto.RegisterDto;
import com.Mahmoud.Karate.System.Entities.Instructor;
import com.Mahmoud.Karate.System.Mapper.InstructorMapper;
import com.Mahmoud.Karate.System.Repository.InstructorRepo;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Data
public class InstructorService {

    private final InstructorMapper instructorMapper;
    private final InstructorRepo instructorRepo;


    public Instructor addInstructor(RegisterDto registerDto) {

        if (instructorRepo.existsByUsername(registerDto.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (instructorRepo.existsByEmail(registerDto.getUsername())) {
            throw new RuntimeException("Email already in use");
        }
        Instructor instructor = instructorMapper.mapToInstructor(registerDto);
        instructorRepo.save(instructor);
        return instructor;



    }

    @Transactional
    public String deleteInstructor(String username) {

        int result = instructorRepo.deleteByUsername(username);
        if(result < 1){
            throw new RuntimeException("no instructor exist");
        }
        return ("the instructor has been deleted successfully");

    }
}
