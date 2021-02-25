package com.yang.model;

import java.io.Serializable;
import lombok.Data;

/**
 * <p>@ProjectName:spring-secrity</p>
 * <p>@Package:com.yang.model</p>
 * <p>@ClassName:AuthenticationRequest</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2021/2/25 9:13</p>
 * <p>@Version:1.0</p>
 */
@Data
public class AuthenticationRequest implements Serializable {

    private static final long serialVersionUID = 9021792458217701863L;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
