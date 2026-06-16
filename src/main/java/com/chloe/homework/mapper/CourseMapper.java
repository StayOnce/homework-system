package com.chloe.homework.mapper;

import com.chloe.homework.entity.Course;
import com.chloe.homework.vo.CourseVO;
import org.apache.ibatis.annotations.Mapper;
import com.chloe.homework.vo.CourseStatisticsVO;
import java.util.List;

@Mapper
public interface CourseMapper {

    List<CourseVO> getCourseList();

    int insert(Course course);

    Course findByCode(String courseCode);

    List<CourseStatisticsVO> getStatistics();

}