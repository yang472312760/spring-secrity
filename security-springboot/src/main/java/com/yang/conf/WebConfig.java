package com.yang.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>@ProjectName:spring-secrity</p>
 * <p>@Package:com.yang.conf</p>
 * <p>@ClassName:WebConfig</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2021/2/25 15:04</p>
 * <p>@Version:1.0</p>
 */
@Configuration//就相当于springmvc.xml文件
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login-view");
        registry.addViewController("/login-view").setViewName("login");

    }

}
