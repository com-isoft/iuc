package com.isoft.iuc.domain;

import com.isoft.ifx.domain.config.AbstractDomainConfig;
import com.isoft.ifx.domain.repository.DefaultJpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by liuqiang03 on 2017/6/26.
 */
@Configuration
@EntityScan
@EnableJpaRepositories(repositoryBaseClass = DefaultJpaRepository.class)
public class DomainConfig extends AbstractDomainConfig {
    @Override
    protected String[] getBitEnumBasePackages() {
        return new String[] { "com.isoft.iuc.domain" };
    }
}
