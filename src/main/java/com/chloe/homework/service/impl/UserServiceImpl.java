package com.chloe.homework.service.impl;

import com.chloe.homework.entity.User;
import com.chloe.homework.exception.BusinessException;
import com.chloe.homework.mapper.UserMapper;
import com.chloe.homework.utils.JwtUtil;
import com.chloe.homework.utils.UserContext;
import com.chloe.homework.service.UserService;
import com.chloe.homework.vo.UserInfoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public String login(String username, String password) {
        User user = userMapper.login(username);
        if (user == null) {
            throw new BusinessException("用户不存在");
        }
        if (!user.getPassword().equals(password)) {
            throw new BusinessException("密码错误");
        }
        return JwtUtil.createToken(user.getId(), user.getUsername(), user.getRole());
    }

    @Override
    public UserInfoVO getCurrentUser() {
        Long userId = UserContext.getUserId();
        User user = userMapper.findById(userId);
        if (user == null) {
            throw new BusinessException("用户不存在");
        }
        UserInfoVO vo = new UserInfoVO();
        vo.setId(user.getId());
        vo.setUsername(user.getUsername());
        vo.setRealName(user.getRealName());
        vo.setRole(user.getRole());
        return vo;
    }

    @Override
    public List<User> getTeacherList() {
        return userMapper.getTeacherList();
    }

    @Override
    public List<User> list() {
        return userMapper.getUserList();
    }

    @Override
    public void add(User user) {
        String role = UserContext.getRole();
        if (!"admin".equals(role)) {
            throw new BusinessException("只有管理员可以添加用户");
        }
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.deleteById(id);
    }
}
