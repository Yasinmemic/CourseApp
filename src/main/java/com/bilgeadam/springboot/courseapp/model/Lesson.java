package com.bilgeadam.springboot.courseapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Lesson extends AbstractEntity implements Serializable {

    public static final long serialVersionUID = -1;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

}
