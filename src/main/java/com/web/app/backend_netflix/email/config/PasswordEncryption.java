package com.web.app.backend_netflix.email.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class PasswordEncryption {

    @Bean
    public PasswordEncoder emailEncoder(){
        return new BCryptPasswordEncoder(100);
    }

    @Bean
    public TextEncryptor textEncryptor(){
        return Encryptors.text("password","value");
    }
}
