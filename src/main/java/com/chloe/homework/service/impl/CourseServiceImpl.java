package com.chloe.homework.service.impl;

import com.chloe.homework.entity.Course;
import com.chloe.homework.mapper.CourseMapper;
import com.chloe.homework.service.CourseService;
import com.chloe.homework.vo.CourseVO;
import com.chloe.homework.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.chloe.homework.vo.CourseStatisticsVO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl
        implements CourseService {

    private final CourseMapper courseMapper;

    @Override
    public List<CourseVO> list() {

        return courseMapper.getCourseList();

    }

    @Override
    public void add(Course course) {

        Course exist =
                courseMapper.findByCode(
                        course.getCourseCode()
                );

        if(exist != null){

            throw new BusinessException(
                    "课程编号已存在"
            );

        }

        courseMapper.insert(course);

    }

    @Override
    public List<CourseStatisticsVO> statistics() {

        return courseMapper.getStatistics();

    }
}