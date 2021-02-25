package com.yang.interceptor;

import com.yang.model.UserDto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * <p>@ProjectName:spring-secrity</p>
 * <p>@Package:com.yang.interceptor</p>
 * <p>@ClassName:SimpleAuthenticationInterceptor</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2021/2/25 10:56</p>
 * <p>@Version:1.0</p>
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Object attribute = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if (attribute == null) {
            writeContent(response, "请先登录");
        }

        UserDto dto = (UserDto) attribute;
        String requestURI = request.getRequestURI();
        if (dto.getAuthorities().contains("p1") && requestURI.contains("r1")) {
            return true;
        }

        if (dto.getAuthorities().contains("p2") && requestURI.contains("r2")) {
            return true;
        }
        writeContent(response, "权限不足，拒绝访问");

        return false;
    }

    /**
     * 响应输出
     */
    public void writeContent(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println(msg);
        writer.close();
        //response.resetBuffer();
    }
}
