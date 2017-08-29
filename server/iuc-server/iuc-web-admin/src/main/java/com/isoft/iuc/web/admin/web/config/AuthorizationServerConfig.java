package com.isoft.iuc.web.admin.web.config;

import com.isoft.ifx.web.config.AbstractAuthServerConfig;
import com.isoft.iuc.domain.repository.ClientRepository;
import com.isoft.iuc.domain.repository.UserRepository;
import com.isoft.iuc.service.impl.ClientService;
import com.isoft.iuc.service.impl.UserService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;

/**
 * Created by liuqiang03 on 2017/6/21.
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AbstractAuthServerConfig {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Bean
    public ClientDetailsService clientDetailsService(ClientRepository repository) {
        return new ClientService(repository);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
        super.configure(endpoints);

        endpoints.authenticationManager(authenticationManager).userDetailsService(userService);
    }
}
