package com.bilgeadam.springboot.courseapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TopicRequest {

    private String name;
    private String description;
}
