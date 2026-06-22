package com.chloe.homework.controller;

import com.chloe.homework.common.Result;
import com.chloe.homework.dto.LoginDTO;
import com.chloe.homework.entity.User;
import com.chloe.homework.service.UserService;
import com.chloe.homework.vo.UserInfoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginDTO dto) {
        String token = userService.login(dto.getUsername(), dto.getPassword());
        return Result.success(token);
    }

    @GetMapping("/info")
    public Result<UserInfoVO> info() {
        return Result.success(userService.getCurrentUser());
    }

    @GetMapping("/teacher/list")
    public Result<List<User>> teacherList() {
        return Result.success(userService.getTeacherList());
    }
}