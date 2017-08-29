package com.isoft.iuc.web.admin.web.config;

import com.isoft.ifx.web.config.AbstractResourceServerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

/**
 * Created by liuqiang03 on 2017/6/28.
 */
@Configuration
@EnableResourceServer
@Order(2)
public class ResourceServer extends AbstractResourceServerConfig {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
            throws Exception {
        super.configure(resources);

        resources.resourceId("iuc");
    }
}
