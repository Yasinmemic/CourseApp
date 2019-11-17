package com.bilgeadam.springboot.courseapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LessonRequest {
    private String name;
    private String description;
}
