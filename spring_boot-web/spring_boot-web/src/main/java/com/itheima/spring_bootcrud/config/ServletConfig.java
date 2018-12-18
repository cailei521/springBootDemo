package com.itheima.spring_bootcrud.config;

import com.itheima.spring_bootcrud.Servlet.MyServlet;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



/**
 * Created by 1111111 on 2018/8/28.
 */
@Configuration
public class ServletConfig extends WebMvcConfigurerAdapter {

    //Servlet注册器
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
            ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return servletRegistrationBean;
    }


    //WebServerFactoryCustomizer  web服务工厂定制器
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
         WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer = new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
             @Override
             public void customize(ConfigurableWebServerFactory factory) {
                    factory.setPort(8083);
             }

         };
         return webServerFactoryCustomizer;

    }

}
