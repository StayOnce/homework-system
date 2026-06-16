package com.chloe.homework.controller;

import com.chloe.homework.common.Result;
import com.chloe.homework.entity.Course;
import com.chloe.homework.service.CourseService;
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

    @GetMapping("/list")
    public Result<List<CourseVO>> list() {

        return Result.success(
                courseService.list()
        );
    }

    @PostMapping("/add")
    public Result<Void> add(
            @RequestBody Course course) {

        courseService.add(course);

        return Result.success();
    }

    @GetMapping("/statistics")
    public Result<List<CourseStatisticsVO>>
    statistics() {

        return Result.success(
                courseService.statistics()
        );

    }
}