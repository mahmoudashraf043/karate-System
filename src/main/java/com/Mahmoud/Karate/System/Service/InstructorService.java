package com.Mahmoud.Karate.System.Service;

import com.Mahmoud.Karate.System.Dto.RegisterDto;
import com.Mahmoud.Karate.System.Entities.Instructor;
import com.Mahmoud.Karate.System.Mapper.InstructorMapper;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Data
public class InstructorService {

    InstructorMapper instructorMapper;
    public ResponseEntity<?> addInstructor(RegisterDto registerDto) {

        Instructor instructor = instructorMapper.mapToInstructor(registerDto);


    }
}
