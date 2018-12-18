package com.itheima.spring_bootcrud.controtller;

import com.itheima.spring_bootcrud.pojo.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;


import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by 1111111 on 2018/8/19.
 */
@Controller
@RequestMapping("/user")
public class UserController {



    @PostMapping("/login")
    public String getUser(String username, String password, Map<String,Object>map, HttpSession session){

        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            User user = new User(username,password);
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else{
            map.put("message","你输入的用户名或密码错误");
            return "login";
        }
    }

}
