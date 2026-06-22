package com.chloe.homework.service;

import com.chloe.homework.entity.User;
import com.chloe.homework.vo.UserInfoVO;

import java.util.List;

public interface UserService {
    String login(String username, String password);
    UserInfoVO getCurrentUser();
    List<User> getTeacherList();
    List<User> list();
    void add(User user);
    void update(User user);
    void delete(Long id);
}
