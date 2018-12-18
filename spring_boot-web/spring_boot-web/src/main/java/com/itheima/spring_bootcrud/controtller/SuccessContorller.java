package com.itheima.spring_bootcrud.controtller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.Map;

/**
 * Created by 1111111 on 2018/8/18.
 */
@Controller
public class SuccessContorller {


    @RequestMapping("/success")
    public String findHTML(Map<String,Object> map){

        String[] array = new String[3];

        array[1] = "wangwu";
        array[0] = "zhangsan";
        array[2] = "赵六";

        map.put("users",array);

        map.put("hello","<h1>你好</h1>");


        return "success";
    }


}
