package com.isoft.iuc.service.impl;

import com.isoft.ifx.core.utils.EnumSetUtils;
import com.isoft.iuc.domain.repository.ClientRepository;
import com.isoft.iuc.domain.specification.ClientSpecifications;
import com.isoft.iuc.service.dto.ClientDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 客户端服务
 * Created by liuqiang03 on 2017/6/23.
 */
@Service
public class ClientService implements ClientDetailsService {
    ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientDetailsDTO clientDetails = this.repository.findOne(ClientDetailsDTO.class, ClientSpecifications.clentIdSpec(clientId));

        return new ClientDetails() {
            @Override
            public String getClientId() {
                return clientDetails.getClientId();
            }

            @Override
            public Set<String> getResourceIds() {
                Set<String> result = new HashSet<>();

                for (String item : clientDetails.getResourceIds().split(";")) {
                    if (!result.contains(item)) {
                        result.add(item);
                    }
                }
                return result;
            }

            @Override
            public boolean isSecretRequired() {
                return true;
            }

            @Override
            public String getClientSecret() {
                return clientDetails.getClientSecret();
            }

            @Override
            public boolean isScoped() {
                return clientDetails.getScope().size() > 0;
            }

            @Override
            public Set<String> getScope() {
                return EnumSetUtils.namesOf(clientDetails.getScope());
            }

            @Override
            public Set<String> getAuthorizedGrantTypes() {
                return EnumSetUtils.namesOf(clientDetails.getAuthorizedGrantTypes());
            }

            @Override
            public Set<String> getRegisteredRedirectUri() {
                Set<String> result = new HashSet<>();

                for (String item : clientDetails.getRedirectUrl().split(";")) {
                    if (!result.contains(item)) {
                        result.add(item);
                    }
                }

                return result;
            }

            @Override
            public Collection<GrantedAuthority> getAuthorities() {
                String[] authorities = new String[clientDetails.getAuthorities().size()];
                EnumSetUtils.namesOf(clientDetails.getAuthorities()).toArray(authorities);
                return AuthorityUtils.createAuthorityList(authorities);
            }

            @Override
            public Integer getAccessTokenValiditySeconds() {
                return clientDetails.getAccessTokenValidity();
            }

            @Override
            public Integer getRefreshTokenValiditySeconds() {
                return clientDetails.getAccessTokenValidity();
            }

            @Override
            public boolean isAutoApprove(String s) {
                return true;
            }

            @Override
            public Map<String, Object> getAdditionalInformation() {
                return clientDetails.getAdditionalInformation();
            }
        };
    }
}
