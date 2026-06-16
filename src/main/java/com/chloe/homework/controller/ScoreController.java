package com.chloe.homework.controller;

import com.chloe.homework.common.Result;
import com.chloe.homework.dto.GradeDTO;
import com.chloe.homework.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.chloe.homework.vo.ScoreVO;
import java.util.List;

@RestController
@RequestMapping("/score")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    @PostMapping("/grade")
    public Result<Void> grade(
            @RequestBody GradeDTO dto) {

        scoreService.grade(dto);

        return Result.success();
    }

    @GetMapping("/my")
    public Result<List<ScoreVO>> myScores() {

        return Result.success(
                scoreService.myScores()
        );
    }
}

