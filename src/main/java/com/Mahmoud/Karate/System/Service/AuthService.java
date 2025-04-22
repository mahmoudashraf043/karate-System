package com.Mahmoud.Karate.System.Service;

import com.Mahmoud.Karate.System.Dto.LoginDto;
import com.Mahmoud.Karate.System.Entities.Instructor;
import com.Mahmoud.Karate.System.Jwt.JwtUtil;
import com.Mahmoud.Karate.System.Repository.InstructorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.BadCredentialsException;



import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {


    private InstructorRepo instructorRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public ResponseEntity<String> Login(LoginDto loginDto){
        try {
        Optional<Instructor> instructor = instructorRepo.findByUserName(loginDto.getUserName());
        if(!instructor.isPresent()) {
            throw new Exception("the user in not exist");

        }
            if (!passwordEncoder.matches(loginDto.getPassword(), instructor.get().getPassword())) {
                throw new BadCredentialsException("Wrong password");
            }
            return jwtUtil.generateToken(instructor.get());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
