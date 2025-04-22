package com.Mahmoud.Karate.System.Dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RegisterDto {


    String firstName;

    String lastName;

    String username;

    String password;

    String email;

    String phone;
}
