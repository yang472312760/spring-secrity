package com.yang.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>@ProjectName:spring-secrity</p>
 * <p>@Package:com.yang.uaa</p>
 * <p>@ClassName:UAAServer</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2021/2/26 15:28</p>
 * <p>@Version:1.0</p>
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(basePackages = { "com.yang.uaa" })
public class UAAServer {

    public static void main(String[] args) {

        SpringApplication.run(UAAServer.class, args);

    }

}
