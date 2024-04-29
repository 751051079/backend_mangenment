package com.springboot.backend.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // 排除不需要 JWT 验证的路径
    private final String[] excludedPaths = {"/api/user/login", "/api/captcha"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 检查请求路径是否在排除列表中
        String requestPath = request.getRequestURI();
        for (String excludedPath : excludedPaths) {
            if (requestPath.startsWith(excludedPath)) {
                return true; // 排除的路径，直接放行
            }
        }

        String token = extractTokenFromHeader(request);
        if (token != null) {
            try {
                Claims claims = jwtTokenProvider.validateToken(token);
                // Token 验证通过，可以允许请求继续进行
                return true;
            } catch (ExpiredJwtException ex) {
                // Token 已过期
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write("Token expired");
            } catch (Exception ex) {
                // 其他验证失败的情况
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write("Invalid token");
            }
        }

        // Token 不存在或验证失败，拒绝请求
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write("Unauthorized");
        return false;
    }

    private String extractTokenFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
