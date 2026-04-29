package com.web.app.backend_netflix.security.dto.request;

import lombok.Data;

@Data
public class UserRequest{

    private String email;
    private String password;
    private String fulName;
    private String role;
    private String active;
}
