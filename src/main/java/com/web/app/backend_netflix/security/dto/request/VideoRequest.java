package com.web.app.backend_netflix.security.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class VideoRequest {

    @NotBlank(message = "Title is Required")
    private String title;
    @Size(max = 4000, message = "Description must should be <= 4000 ")
    private String description;

    private Integer year;
    private String rating;
    private Integer duration;
    private String src;
    private String poster;
    private boolean publisher;
    private List<String> categories;



}
