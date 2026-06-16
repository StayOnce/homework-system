package com.chloe.homework.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HomeworkVO {

    private Long id;

    private String title;

    private String courseName;

    private String teacherName;

    private LocalDateTime deadline;

    private String status;

}