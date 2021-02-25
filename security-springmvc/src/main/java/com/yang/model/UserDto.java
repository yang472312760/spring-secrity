package com.yang.model;

import java.io.Serializable;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>@ProjectName:spring-secrity</p>
 * <p>@Package:com.yang.model</p>
 * <p>@ClassName:UserDto</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2021/2/25 9:13</p>
 * <p>@Version:1.0</p>
 */
@Data
@AllArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = -3515420710200294894L;

    public static final String SESSION_USER_KEY = "_user";

    private String id;

    private String username;

    private String password;

    private String fullname;

    private String mobile;

    /**
     * 用户权限
     */
    private Set<String> authorities;

}
