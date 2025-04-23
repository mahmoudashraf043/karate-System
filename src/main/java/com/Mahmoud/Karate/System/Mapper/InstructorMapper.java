package com.Mahmoud.Karate.System.Mapper;

import com.Mahmoud.Karate.System.Dto.RegisterDto;
import com.Mahmoud.Karate.System.Entities.Instructor;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Data
public class InstructorMapper {

    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;


    public Instructor mapToInstructor(RegisterDto registerDto) {
        registerDto.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        return objectMapper.convertValue(registerDto, Instructor.class);
    }


}
