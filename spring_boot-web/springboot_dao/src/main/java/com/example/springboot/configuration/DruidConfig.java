package com.example.springboot.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.rmi.MarshalledObject;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1111111 on 2018/8/30.
 */
@Configuration
public class DruidConfig {
    //设置自定义的数据源  properties中的配置路径为spring.datasource
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
         return new DruidDataSource();
    }

    //配置一个Druid监控
    @Bean
    public ServletRegistrationBean servletRegistrationBean (){

        //设置访问路径urlMapping为/druid/*
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        Map<String,Object> initParams = new HashMap<>();
        //配置白名单
        initParams.put("allow","127.0.0.1");
        //配置黑名单  优先于白名单
        initParams.put("deny","");
        //配置登陆用户
        initParams.put("loginUsername","admin");
        //配置登陆密码
        initParams.put("loginPassword","123456");

        servletRegistrationBean.setInitParameters(initParams);
        return servletRegistrationBean;
    }

    //配置一个监控web的filter过滤器
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //设置filter为web filter
        filterRegistrationBean.setFilter(new WebStatFilter());
        //设置过滤的路径
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }


}
