package com.chloe.homework.config;

import com.chloe.homework.utils.JwtUtil;
import com.chloe.homework.utils.UserContext;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            response.setStatus(401);
            return false;
        }
        Claims claims = JwtUtil.parseToken(token);
        Long userId = ((Number) claims.get("userId")).longValue();
        String role = (String) claims.get("role");
        UserContext.setUserId(userId);
        UserContext.setRole(role);
        return true;
    }
}