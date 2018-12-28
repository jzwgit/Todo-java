package com.jzw.todo.conf;


import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //拦截器（是否登录判断）
    public void addInterceptors(InterceptorRegistry registry){

    }

    // 设置跨域访问
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping( "/**")
                .allowedOrigins("*")//单独配置可以跨域访问的地址
                .allowedMethods("*")//可以允许跨域的方式（get/post等)
                .allowCredentials(true);//允许客户端带上cookie
    }

    //格式化
    public void addFormatters(FormatterRegistry registry){

    }

    //其他全局定制接口
}
