package com.web.app.backend_netflix.security.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmailRequest {
    @NotNull(message = "Email is Required")
    @Email(message = "Invalid Email")
    private String email;

}
