package com.web.app.backend_netflix.email.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "conformation")
public class Confirmation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String token;
    @CreatedDate
    @Column(name = "Created_date", nullable = false, updatable = false)
    private LocalDateTime createdDAte;
    @Column(name = "Created_date", nullable = false, updatable = false)
    @LastModifiedDate
    private String lastModifiedDate;

    @OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name = "user_id")
    private User user;

    public Confirmation(User user){
        this.user=user;
        this.createdDAte=LocalDateTime.now();
        this.token= UUID.randomUUID().toString();
    }
}
