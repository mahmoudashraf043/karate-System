package com.Mahmoud.Karate.System.Controller;

import com.Mahmoud.Karate.System.Dto.RegisterDto;
import com.Mahmoud.Karate.System.Entities.Instructor;
import com.Mahmoud.Karate.System.Service.InstructorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("instructor")
@Data
@RestController
public class InstructorController {

    private final RegisterDto registerDto;
    private final InstructorService instructorService;


    @PreAuthorize("Instructor")
    @PostMapping("/create")
    public ResponseEntity<Instructor> addInstructor(@RequestBody RegisterDto registerDto){
        return new ResponseEntity<>(instructorService.addInstructor(registerDto) , HttpStatus.OK);
    }

    @PreAuthorize("Instructor")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteInstructor(@PathVariable String username){
        return new ResponseEntity<>(instructorService.deleteInstructor(username) , HttpStatus.OK);
    }


}
