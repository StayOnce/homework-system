package com.chloe.homework.service.impl;

import com.chloe.homework.entity.User;
import com.chloe.homework.mapper.UserCourseMapper;
import com.chloe.homework.service.UserCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCourseServiceImpl implements UserCourseService {
    private final UserCourseMapper userCourseMapper;

    @Override
    public List<User> getStudentsByCourseId(Long courseId) {
        return userCourseMapper.getStudentsByCourseId(courseId);
    }

    @Override
    public void addStudentToCourse(Long courseId, Long studentId) {
        userCourseMapper.addStudentToCourse(courseId, studentId);
    }

    @Override
    public void removeStudentFromCourse(Long courseId, Long studentId) {
        userCourseMapper.removeStudentFromCourse(courseId, studentId);
    }

    @Override
    public List<User> getUnassignedStudents(Long courseId) {
        return userCourseMapper.getUnassignedStudents(courseId);
    }

    @Override
    public void assignStudents(Long courseId, List<Long> studentIds) {
        for (Long studentId : studentIds) {
            userCourseMapper.addStudentToCourse(courseId, studentId);
        }
    }
}