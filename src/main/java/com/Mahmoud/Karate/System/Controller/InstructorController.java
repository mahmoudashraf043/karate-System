package com.Mahmoud.Karate.System.Controller;

import com.Mahmoud.Karate.System.Dto.RegisterDto;
import com.Mahmoud.Karate.System.Service.InstructorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("instructor")
@Data
@RestController
public class InstructorController {

    private final RegisterDto registerDto;
    private final InstructorService instructorService;


    @PreAuthorize("Instructor")
    @PostMapping("/create")
    public ResponseEntity<?> addInstructor(@RequestBody RegisterDto registerDto){
        return instructorService.addInstructor(registerDto);
    }
}
