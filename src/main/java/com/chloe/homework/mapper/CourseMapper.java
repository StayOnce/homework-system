package com.chloe.homework.mapper;

import com.chloe.homework.entity.Course;
import com.chloe.homework.vo.CourseVO;
import org.apache.ibatis.annotations.Mapper;
import com.chloe.homework.vo.CourseStatisticsVO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CourseMapper {
    List<CourseVO> getCourseList();
    List<Long> getCourseIdsByStudentId(@Param("studentId") Long studentId);
    int insert(Course course);
    Course findByCode(String courseCode);
    List<CourseStatisticsVO> getStatistics();
    List<CourseStatisticsVO> getStatisticsByTeacherId(@Param("teacherId") Long teacherId);
    int deleteById(Long id);
    int update(Course course);
    Integer getTotalCount();
    Integer getCourseCountByTeacherId(@Param("teacherId") Long teacherId);
    Integer getCourseCountByStudentId(@Param("studentId") Long studentId);
    Integer getStudentCountByTeacherId(@Param("teacherId") Long teacherId);
}