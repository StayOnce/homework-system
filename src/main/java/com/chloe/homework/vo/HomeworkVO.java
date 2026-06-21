package com.chloe.homework.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HomeworkVO {

    private Long id;

    private String title;

    private String content;

    private Long courseId;

    private String courseName;

    private Long teacherId;

    private String teacherName;

    private LocalDateTime deadline;

    private String status;

    private LocalDateTime publishTime;
}