package com.chloe.homework.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Course {
    private Long id;
    private String courseName;
    private String courseCode;
    private Long teacherId;
    private String description;
    private LocalDateTime createTime;
}