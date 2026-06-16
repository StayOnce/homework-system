package com.chloe.homework.service;

import com.chloe.homework.vo.UserInfoVO;

public interface UserService {

    String login(String username,
                 String password);

    UserInfoVO getCurrentUser();

}