package com.chloe.homework.service;

import com.chloe.homework.entity.Course;
import com.chloe.homework.vo.CourseVO;
import com.chloe.homework.vo.CourseStatisticsVO;

import java.util.List;

public interface CourseService {
    List<CourseVO> list();
    void add(Course course);
    List<CourseStatisticsVO> statistics();
    void delete(Long id);
    void update(Course course);
}