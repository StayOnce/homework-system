package com.chloe.homework.vo;

import lombok.Data;

@Data
public class CourseVO {
    private Long id;
    private String courseName;
    private String courseCode;
    private Long teacherId;
    private String teacherName;
    private String description;
}