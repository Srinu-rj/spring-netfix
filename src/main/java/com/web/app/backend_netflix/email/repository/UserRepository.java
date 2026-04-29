package com.web.app.backend_netflix.email.repository;

import com.web.app.backend_netflix.email.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmailIgnoreCase(String email);
    Boolean existsByEmail(String email);

}
