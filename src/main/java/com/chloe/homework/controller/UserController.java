package com.chloe.homework.controller;

import com.chloe.homework.common.Result;
import com.chloe.homework.entity.User;
import com.chloe.homework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/list")
    public Result<List<User>> list() {
        return Result.success(userService.list());
    }

    @PostMapping("/add")
    public Result<Void> add(@RequestBody User user) {
        userService.add(user);
        return Result.success();
    }

    @PutMapping("/update")
    public Result<Void> update(@RequestBody User user) {
        userService.update(user);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return Result.success();
    }

    @GetMapping("/student/list")
    public Result<List<User>> getStudentList() {
        return Result.success(userService.list().stream()
                .filter(u -> "student".equals(u.getRole()))
                .toList());
    }

    @GetMapping("/teacher/list")
    public Result<List<User>> getTeacherList() {
        return Result.success(userService.list().stream()
                .filter(u -> "teacher".equals(u.getRole()))
                .toList());
    }
}