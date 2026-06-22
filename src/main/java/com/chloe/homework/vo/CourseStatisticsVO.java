package com.chloe.homework.vo;

import lombok.Data;

@Data
public class CourseStatisticsVO {
    private Long courseId;
    private String courseName;
    private Integer studentCount;
    private Integer submitCount;
    private Integer unSubmitCount;
    private Double averageScore;
    private Double completeRate;
}