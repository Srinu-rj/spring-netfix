package com.web.app.backend_netflix.security.repository;

import com.web.app.backend_netflix.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean exitsByEmailIgnoreCase(String email);
    Optional<User> findByEmailCase(String email);
    boolean exitsByPhoneNumber(String phNumber);
}
