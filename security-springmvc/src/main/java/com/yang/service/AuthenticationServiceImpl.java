package com.yang.service;

import com.yang.model.AuthenticationRequest;
import com.yang.model.UserDto;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>@ProjectName:spring-secrity</p>
 * <p>@Package:com.yang.service</p>
 * <p>@ClassName:AuthenticationServiceImpl</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2021/2/25 9:18</p>
 * <p>@Version:1.0</p>
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private Map<String, UserDto> userMap = new HashMap<>();

    {
        Set<String> a1 = new HashSet<>();
        a1.add("p1");

        Set<String> a2 = new HashSet<>();
        a2.add("p2");

        userMap.put("zhangsan", new UserDto("1010", "zhangsan", "123", "张三", "122222", a1));
        userMap.put("lisi", new UserDto("1011", "lisi", "456", "李四", "156455856", a2));
    }

    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        if (authenticationRequest == null || StringUtils.isEmpty(authenticationRequest.getUsername()) || StringUtils
                .isEmpty(authenticationRequest.getPassword())) {
            throw new RuntimeException("账号或密码为空");
        }

        UserDto userDto = getUserDto(authenticationRequest.getUsername());
        if (userDto == null) {
            throw new RuntimeException("查询不到该用户");
        }

        if (!authenticationRequest.getPassword().equals(userDto.getPassword())) {
            throw new RuntimeException("账号密码错误");
        }

        return userDto;
    }

    private UserDto getUserDto(String username) {
        return userMap.get(username);
    }
}
