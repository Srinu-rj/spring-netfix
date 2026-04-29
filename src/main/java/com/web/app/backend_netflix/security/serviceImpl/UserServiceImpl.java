package com.web.app.backend_netflix.security.serviceImpl;

import com.web.app.backend_netflix.security.dto.request.ChangePasswordRequest;
import com.web.app.backend_netflix.security.dto.request.ProfileUpdateRequest;
import com.web.app.backend_netflix.security.model.UserMapper;
import com.web.app.backend_netflix.security.repository.UserRepository;
import com.web.app.backend_netflix.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public void updateProfileInfo(ProfileUpdateRequest request, String userId) {

    }

    @Override
    public void changePassword(ChangePasswordRequest request, String userId) {

    }

    @Override
    public void deactivateAccount(String userId) {

    }

    @Override
    public void reactiveAccount(String userId) {

    }

    @Override
    public void deleteAccount(String userId) {

    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return this.userRepository.findByEmailCase(userEmail)
                .orElseThrow(()->new RuntimeException("User not Found with userEmail"));

    }
}
