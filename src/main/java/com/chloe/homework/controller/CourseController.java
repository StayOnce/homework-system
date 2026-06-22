package com.chloe.homework.controller;

import com.chloe.homework.common.Result;
import com.chloe.homework.entity.Course;
import com.chloe.homework.entity.User;
import com.chloe.homework.service.CourseService;
import com.chloe.homework.service.UserCourseService;
import com.chloe.homework.vo.CourseVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.chloe.homework.vo.CourseStatisticsVO;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final UserCourseService userCourseService;

    @GetMapping("/list")
    public Result<List<CourseVO>> list() {
        return Result.success(courseService.list());
    }

    @PostMapping("/add")
    public Result<Void> add(@RequestBody Course course) {
        courseService.add(course);
        return Result.success();
    }

    @GetMapping("/statistics")
    public Result<List<CourseStatisticsVO>> statistics() {
        return Result.success(courseService.statistics());
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        courseService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result<Void> update(@RequestBody Course course) {
        courseService.update(course);
        return Result.success();
    }

    @GetMapping("/{courseId}/students")
    public Result<List<User>> getCourseStudents(@PathVariable Long courseId) {
        return Result.success(userCourseService.getStudentsByCourseId(courseId));
    }

    @GetMapping("/{courseId}/students/unassigned")
    public Result<List<User>> getUnassignedStudents(@PathVariable Long courseId) {
        return Result.success(userCourseService.getUnassignedStudents(courseId));
    }

    @PostMapping("/{courseId}/students")
    public Result<Void> addStudentToCourse(
            @PathVariable Long courseId,
            @RequestParam(required = false) Long studentId,
            @RequestBody(required = false) java.util.Map<String, Long> body
    ) {
        Long actualStudentId = studentId != null ? studentId : (body != null ? body.get("studentId") : null);
        if (actualStudentId == null) {
            return Result.fail("studentId不能为空");
        }
        userCourseService.addStudentToCourse(courseId, actualStudentId);
        return Result.success();
    }

    @PostMapping("/{courseId}/students/batch")
    public Result<Void> addStudentsToCourse(@PathVariable Long courseId, @RequestBody List<Long> studentIds) {
        userCourseService.assignStudents(courseId, studentIds);
        return Result.success();
    }

    @DeleteMapping("/{courseId}/students/{studentId}")
    public Result<Void> removeStudentFromCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        userCourseService.removeStudentFromCourse(courseId, studentId);
        return Result.success();
    }
}