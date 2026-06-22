package com.chloe.homework.vo;

import lombok.Data;

import java.util.List;

@Data
public class DashboardVO {
    private String userName;
    private String userRole;
    private Integer totalCourses;
    private Integer totalHomeworks;
    private Integer totalStudents;
    private Integer totalSubmits;
    private Double averageScore;
    private List<CourseStatisticsVO> courseStatistics;
    private Integer pendingGrades;
    private Integer pendingSubmits;
}