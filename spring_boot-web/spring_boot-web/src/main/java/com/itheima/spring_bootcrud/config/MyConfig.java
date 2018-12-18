package com.itheima.spring_bootcrud.config;



import com.itheima.spring_bootcrud.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 1111111 on 2018/8/18.
 */
@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {







    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       // super.addViewControllers(registry);
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("/customer");
    }

 /*   @Override
    public void addInterceptors(InterceptorRegistry registry) {
       // super.addInterceptors(registry);
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        registry.addInterceptor(loginInterceptor).addPathPatterns("*//**").excludePathPatterns("/index.html","/login.html","/","/user/login","/js*//**");
    }
*/
}
