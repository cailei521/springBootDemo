package com.itheima.spring_bootcrud.Interceptor;


import com.itheima.spring_bootcrud.pojo.User;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 1111111 on 2018/8/27.
 */
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       User user = (User) request.getSession().getAttribute("loginUser");
       if(user == null){
           request.setAttribute("message","没有权限,请先登录");
           request.getRequestDispatcher("index.html").forward(request,response);
           return false;
       }else {
           return  true;
       }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
