package com.isoft.iuc.service.dto;

import com.isoft.ifx.service.dto.QueryDTO;
import com.isoft.iuc.domain.enumeration.AuthorityRoleType;
import com.isoft.iuc.domain.enumeration.GrantType;
import com.isoft.iuc.domain.enumeration.Scope;
import com.isoft.iuc.domain.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumSet;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
public class ClientDetailsDTO implements QueryDTO<Client> {
    /**
     * 标识
     */
    private String clientId;

    /**
     * 秘钥
     */
    private String clientSecret;

    /**
     * 资源标识
     */
    private String resourceIds;

    /**
     * 授权范围
     */
    private EnumSet<Scope> scope;

    /**
     * 授权类型
     */
    private EnumSet<GrantType> authorizedGrantTypes;

    /**
     * 网址
     */
    private String redirectUrl;

    /**
     * 授权角色
     */
    private EnumSet<AuthorityRoleType> authorities;

    /**
     * 令牌有效时间
     */
    private Integer accessTokenValidity;

    /**
     * 刷新令牌有效时间
     */
    private Integer refreshTokenValidity;

    /**
     * 默认授权
     */
    private EnumSet<Scope> autoApproveScopes;

    /**
     * 附加信息
     */
    private HashMap<String, Object> additionalInformation;
}
