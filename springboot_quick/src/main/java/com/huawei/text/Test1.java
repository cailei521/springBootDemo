package com.huawei.text;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by 1111111 on 2018/12/17.
 */
@Controller
public class Test1 {

    @RequestMapping("/quick")
    @ResponseBody
    public String getString(){
        return "NIHAO springboot  !!!!";
    }

}
