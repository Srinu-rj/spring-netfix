package com.web.app.backend_netflix.email.service;

import com.web.app.backend_netflix.email.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User saveUser(User user);
    Boolean verifyToken(String token);
}
