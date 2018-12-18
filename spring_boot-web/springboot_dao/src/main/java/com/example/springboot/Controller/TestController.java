package com.example.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by 1111111 on 2018/8/30.
 */
@Controller
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @GetMapping("/query/{id}")
    @ResponseBody
    public Map<String,Object> find(@PathVariable("id") Integer id){

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM book");

        return maps.get(id-1);


    }
}
