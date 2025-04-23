package com.Mahmoud.Karate.System.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterDto {


    @NotBlank
    String firstName;

    @NotBlank
    String lastName;

    @NotBlank
    String username;

    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters")
    String password;

    @Email(message = "Invalid email format")
    @NotBlank
    String email;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number")
    String phone;
}
