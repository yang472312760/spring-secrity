package com.yang.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * <p>@ProjectName:spring-secrity</p>
 * <p>@Package:com.yang.uaa.config</p>
 * <p>@ClassName:TokenConfig</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2021/2/26 16:04</p>
 * <p>@Version:1.0</p>
 */
@Configuration
public class TokenConfig {

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

}
