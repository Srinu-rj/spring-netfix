package com.web.app.backend_netflix.email.controller;

import com.web.app.backend_netflix.email.httpResponse.HttpResponse;
import com.web.app.backend_netflix.email.model.User;
import com.web.app.backend_netflix.email.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<HttpResponse>createUser(@RequestBody User user){
        User createUser= userService.saveUser(user);

        return ResponseEntity.created(URI.create("")).body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("user",createUser))
                        .message("User Created")
                        .statusCode(HttpStatus.CREATED.value())
                        .status(HttpStatus.CREATED)
                        .build()
        );
    }
    @GetMapping("/{token}")
    public ResponseEntity<HttpResponse>confirmUserAccount(@RequestParam("token") String token){
        Boolean isSuccess=userService.verifyToken(token);

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("Success",isSuccess))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Account Verified")
                        .build()
        );
    }























}
