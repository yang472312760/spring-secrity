package com.yang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>@ProjectName:spring-secrity</p>
 * <p>@Package:com.yang</p>
 * <p>@ClassName:TestBCrypt</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2021/2/25 16:25</p>
 * <p>@Version:1.0</p>
 */
@RunWith(SpringRunner.class)
public class TestBCrypt {
    @Test
    public void test1() {
        //对原始密码加密
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw);
        //校验原始密码和BCrypt密码是否一致
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$NlBC84MVb7F95EXYTXwLneXgCca6/GipyWR5NHm8K0203bSQMLpvm");
        System.out.println(checkpw);
    }
}
