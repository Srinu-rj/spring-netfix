package com.web.app.backend_netflix.security.controller;


import com.web.app.backend_netflix.security.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;


}