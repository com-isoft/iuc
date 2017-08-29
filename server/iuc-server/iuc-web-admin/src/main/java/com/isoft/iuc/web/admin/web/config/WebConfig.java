package com.isoft.iuc.web.admin.web.config;

import com.isoft.ifx.web.config.AbstractWebConfig;
import com.isoft.iuc.service.ServiceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by liuqiang03 on 2017/6/22.
 */
@Configuration
@Import(ServiceConfig.class)
public class WebConfig extends AbstractWebConfig {
}
