package com.web.app.backend_netflix;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
// TODO IF YOU WANT IGNORE ENTIRE PACKAGE 👇👇
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.REGEX,
                pattern = "com.web.app.backend_netflix.customsecurity.*"
        )
)
@EnableAsync
@EnableJpaAuditing
@EnableEncryptableProperties
public class BackendNetflixApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendNetflixApplication.class, args);
        SpringApplication application = new SpringApplication(BackendNetflixApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        System.out.println("APPLICATION RUNNING..");
    }

}
