package com.chloe.homework.service.impl;

import com.chloe.homework.entity.Course;
import com.chloe.homework.exception.BusinessException;
import com.chloe.homework.mapper.CourseMapper;
import com.chloe.homework.service.CourseService;
import com.chloe.homework.utils.UserContext;
import com.chloe.homework.vo.CourseStatisticsVO;
import com.chloe.homework.vo.CourseVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        String role =
                UserContext.getRole();

        if(!"admin".equals(role)){

            throw new BusinessException(
                    "只有管理员可以新增课程"
            );

        }

        Course exist =
                courseMapper.findByCode(
                        course.getCourseCode()
                );

        if (exist != null) {

            throw new BusinessException(
                    "课程编号已存在"
            );

        }

        if (course.getTeacherId() == null) {

            throw new BusinessException(
                    "请选择授课教师"
            );

        }

        courseMapper.insert(course);

    }

    @Override
    public List<CourseStatisticsVO> statistics() {

        return courseMapper.getStatistics();

    }

    @Override
    public void delete(Long id) {
        String role =
                UserContext.getRole();

        if(!"admin".equals(role)){

            throw new BusinessException(
                    "只有管理员可以删除课程"
            );

        }

        courseMapper.deleteById(id);

    }

    @Override
    public void update(Course course) {

        courseMapper.update(course);

    }
}