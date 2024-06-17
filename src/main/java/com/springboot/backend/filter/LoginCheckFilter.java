package com.springboot.backend.filter;

import com.alibaba.fastjson.JSON;
import com.springboot.backend.common.BaseContext;
import com.springboot.backend.common.R;
import com.springboot.backend.config.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        log.info("Authorization Header: {}", request.getHeader("Authorization"));
        String requestURI = request.getRequestURI();
        log.info("请求路径：{}", requestURI);

        String[] urls = new String[]{
                "/api/getCaptcha",
                "/api/user/login"
        };

        boolean needProcess = check(urls, requestURI);

        if (needProcess) {
            log.info("本次请求{}不需要处理，直接放行", requestURI);
            filterChain.doFilter(request, response);
            return;
        }

        String header = request.getHeader("Authorization");
        log.info("Authorization Header: {}", header);
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            if (jwtTokenProvider.validateToken(token)) {
                String username = jwtTokenProvider.getUsernameFromToken(token);
                Long userId = jwtTokenProvider.getUserIdFromToken(token);
                log.info("用户名: {}, 用户ID: {}", username, userId);
                if (username != null && userId != null) {
                    BaseContext.setCurrentId(userId);
                    filterChain.doFilter(request, response);
                    return;
                }
            }
        }

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        log.info("本次请求{}用户未登录，返回未登录结果", requestURI);
    }

    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            if (PATH_MATCHER.match(url, requestURI)) {
                return true;
            }
        }
        return false;
    }
}
