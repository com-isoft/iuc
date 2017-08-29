package com.isoft.iuc.service;

import com.isoft.ifx.service.config.AbstractServiceConfig;
import com.isoft.iuc.domain.DomainConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by liuqiang03 on 2017/6/26.
 */
@Configuration
@Import(DomainConfig.class)
@ComponentScan
public class ServiceConfig extends AbstractServiceConfig {
}
