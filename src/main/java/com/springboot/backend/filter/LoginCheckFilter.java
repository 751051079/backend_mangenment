package com.springboot.backend.filter;

import com.springboot.backend.common.BaseContext;
import com.springboot.backend.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.alibaba.fastjson.JSON;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")  // "/*"表示拦截所有请求
@Slf4j
public class LoginCheckFilter implements Filter {

    // 路径匹配器
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 将ServletRequest和ServletResponse转换成HttpServletRequest和HttpServletResponse
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 1.获取本次处理的url
        String requestURI = request.getRequestURI();                            // Slf4j的日志输出

        // 2.判断本次请求是否需要处理
        String[] urls = new String[]{
                "/api/getCaptcha",
                "/api/user/login"
        };                              // 不需要处理的url

        boolean needProcess = check(urls, requestURI);  // 判断本次请求是否需要处理

        // 3.如果不需要处理，则直接放行
        if (needProcess) {
            log.info("本次请求{}不需要处理，直接放行", requestURI);                     // Slf4j的日志输出
            filterChain.doFilter(request, response);    // 直接放行
            return;                                     // 结束方法
        }

        // 4-1.判断员工登陆状态，如果为已登录，则放行
        Object employeeId = request.getSession().getAttribute("employee");        // 获取session中的employee对象
        if (employeeId != null) {
            log.info("本次请求{}，用户id={}，已登录，直接放行", requestURI, employeeId);   // Slf4j的日志输出

            // 在该线程中保存当前用户的id，BaseContext为common包中的工具类，用于保存当前线程的数据
            BaseContext.setCurrentId((Long) employeeId);

            filterChain.doFilter(request, response);    // 放行
            return;                                     // 结束方法
        }

        // 4-2.判断用户登陆状态，如果为已登录，则放行
        Object user = request.getSession().getAttribute("user");
        if (user!= null) {
            log.info("本次请求{}，用户id={}，已登录，直接放行", requestURI, user);   // Slf4j的日志输出

            Long userId = (Long) user;
            // 在该线程中保存当前用户的id，BaseContext为common包中的工具类，用于保存当前线程的数据
            BaseContext.setCurrentId(userId);

            filterChain.doFilter(request, response);    // 放行
            return;                                     // 结束方法
        }

        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));   // 通过输出流，返回未登录结果
        log.info("本次请求{}用户未登录，返回未登录结果", requestURI);                    // Slf4j的日志输出

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