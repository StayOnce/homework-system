package com.chloe.homework.controller;

import com.chloe.homework.common.Result;
import com.chloe.homework.entity.Homework;
import com.chloe.homework.service.HomeworkService;
import com.chloe.homework.vo.HomeworkVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homework")
@RequiredArgsConstructor
public class HomeworkController {

    private final HomeworkService homeworkService;

    @PostMapping("/add")
    public Result<Void> add(
            @RequestBody Homework homework) {

        homeworkService.add(
                homework
        );

        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<HomeworkVO>> list() {

        return Result.success(
                homeworkService.list()
        );
    }
}