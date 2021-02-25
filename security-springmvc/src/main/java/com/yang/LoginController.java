package com.yang;

import com.alibaba.fastjson.JSON;
import com.yang.model.AuthenticationRequest;
import com.yang.model.UserDto;
import com.yang.service.AuthenticationService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@ProjectName:spring-secrity</p>
 * <p>@Package:com.yang</p>
 * <p>@ClassName:LoginController</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2021/2/25 9:27</p>
 * <p>@Version:1.0</p>
 */
@RestController
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "login", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String login(AuthenticationRequest authenticationRequest, HttpSession session) {
        UserDto authentication = authenticationService.authentication(authenticationRequest);
        session.setAttribute(UserDto.SESSION_USER_KEY, authentication);
        return authentication.getFullname() + "登录成功";
    }

    @GetMapping(value = "logout", produces = { "application/json;charset=UTF-8" })
    public String logout(HttpSession session) {
        session.invalidate();
        return "退出成功";
    }

    @GetMapping(value = "r/r1", produces = { "application/json;charset=UTF-8" })
    public String r1(HttpSession session) {

        String fullName = null;

        Object attribute = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (attribute != null) {
            fullName = ((UserDto) attribute).getFullname();
        } else {
            fullName = "匿名";
        }
        return fullName + "访问资源R1";
    }

    @GetMapping(value = "r/r2", produces = { "application/json;charset=UTF-8" })
    public String r2(HttpSession session) {

        String fullName = null;

        Object attribute = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (attribute != null) {
            fullName = ((UserDto) attribute).getFullname();
        } else {
            fullName = "匿名";
        }
        return fullName + "访问资源R2";
    }

}
