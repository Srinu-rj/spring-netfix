package com.web.app.backend_netflix.email.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@SuperBuilder
@Table(name = "email_user")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "full_name", nullable = false,unique = true)
    private String name;
    @Email
    @Column(name = "email",nullable = false,unique = true,insertable = false)
    private String email;
    @Column(name = "password",nullable = false,unique = true, updatable = true)
    private String password;
    @Column(name = "isEnable")
    private boolean isEnabled;
    @CreatedDate
    @CreationTimestamp
    @Column(name = "Created_date",nullable = false,updatable = false)
    private String createdDate;
    @Column(name = "Created_date",nullable = false,updatable = false)
    @LastModifiedDate
    private String lastModifiedDate;

}
