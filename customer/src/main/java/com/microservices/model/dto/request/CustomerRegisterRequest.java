package com.ajibprojects.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRegisterRequest {
    @NotBlank(message = "Firstname cannot be blank")
    String firstName;

    @NotBlank(message = "Lastname cannot be blank")
    String lastName;

    @NotBlank(message = "Email cannot be blank")
    String email;
}
