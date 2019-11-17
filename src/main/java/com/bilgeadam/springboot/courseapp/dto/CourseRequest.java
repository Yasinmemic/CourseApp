package com.bilgeadam.springboot.courseapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseRequest {

    private String name;
    private String description;
}
