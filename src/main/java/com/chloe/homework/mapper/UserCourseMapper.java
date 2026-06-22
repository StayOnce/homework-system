package com.chloe.homework.mapper;

import com.chloe.homework.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCourseMapper {
    List<User> getStudentsByCourseId(@Param("courseId") Long courseId);
    void addStudentToCourse(@Param("courseId") Long courseId, @Param("studentId") Long studentId);
    void removeStudentFromCourse(@Param("courseId") Long courseId, @Param("studentId") Long studentId);
    List<User> getUnassignedStudents(@Param("courseId") Long courseId);
    List<Long> getStudentIdsByCourseId(@Param("courseId") Long courseId);
}