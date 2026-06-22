package com.chloe.homework.service;

import com.chloe.homework.entity.User;

import java.util.List;

public interface UserCourseService {
    List<User> getStudentsByCourseId(Long courseId);
    void addStudentToCourse(Long courseId, Long studentId);
    void removeStudentFromCourse(Long courseId, Long studentId);
    List<User> getUnassignedStudents(Long courseId);
    void assignStudents(Long courseId, List<Long> studentIds);
}