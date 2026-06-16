package com.chloe.homework.controller;

import com.chloe.homework.common.Result;
import com.chloe.homework.dto.SubmitDTO;
import com.chloe.homework.service.HomeworkSubmitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/submit")
@RequiredArgsConstructor
public class HomeworkSubmitController {

    private final HomeworkSubmitService submitService;

    @PostMapping
    public Result<Void> submit(
            @RequestBody SubmitDTO dto) {

        submitService.submit(dto);

        return Result.success();
    }
}