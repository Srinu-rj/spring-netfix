package com.web.app.backend_netflix.security.service;

import com.web.app.backend_netflix.security.dto.request.ChangePasswordRequest;
import com.web.app.backend_netflix.security.dto.request.ProfileUpdateRequest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    void updateProfileInfo(ProfileUpdateRequest request, String userId);
    void changePassword(ChangePasswordRequest request,String userId);
    void deactivateAccount(String userId);
    void reactiveAccount(String userId);
    void deleteAccount(String userId);
}
