package com.chloe.homework.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Homework {
    private Long id;
    private String title;
    private String content;
    private Long courseId;
    private Long teacherId;
    private LocalDateTime publishTime;
    private LocalDateTime deadline;
    private String status;
    private LocalDateTime createTime;
}