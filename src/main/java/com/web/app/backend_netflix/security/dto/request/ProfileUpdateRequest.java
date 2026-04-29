package com.web.app.backend_netflix.security.dto.request;


import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileUpdateRequest {

    private String firestName;
    private String lastName;
    private LocalDateTime dateOfBirth;
}
