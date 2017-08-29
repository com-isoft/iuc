package com.isoft.iuc.domain.model;

import com.isoft.ifx.core.annotation.Description;
import com.isoft.ifx.domain.annoation.EnumType;
import com.isoft.ifx.domain.model.AbstractAuditableAggregateRoot;
import com.isoft.iuc.domain.enumeration.AuthorityRoleType;
import com.isoft.iuc.domain.enumeration.GrantType;
import com.isoft.iuc.domain.enumeration.Scope;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.EnumSet;
import java.util.HashMap;

/**
 * 客户端
 * Created by liuqiang03 on 2017/6/22.
 */
@Entity
@Table(name = "client_info")
@Description("客户端")
public class Client extends AbstractAuditableAggregateRoot {
    /**
     * 标识
     */
    @Column(nullable = false, unique = true, length = 32)
    @NotNull(message = "标识不能为空!")
    @Description("标识")
    private String clientId;

    /**
     * 秘钥
     */
    @Column(nullable = false, length = 256)
    @NotNull(message = "秘钥不能为空!")
    @Description("秘钥")
    private String clientSecret;

    /**
     * 资源标识
     */
    @Column(nullable = false, length = 256)
    @NotNull(message = "资源标识为空!")
    @Description("资源标识")
    private String resourceIds;

    /**
     * 授权范围
     */
    @Column(nullable = false)
    @NotNull(message = "资源标识为空!")
    @Description("资源标识")
    @Type(type = "com.isoft.ifx.domain.type.BitEnumSetType")
    @EnumType(type = "com.isoft.iuc.domain.enumeration.Scope")
    private EnumSet<Scope> scope;

    /**
     * 授权类型
     */
    @Column(nullable = false)
    @NotNull(message = "授权类型不能为空!")
    @Description("授权类型")
    @Type(type = "com.isoft.ifx.domain.type.BitEnumSetType")
    @EnumType(type = "com.isoft.iuc.domain.enumeration.GrantType")
    private EnumSet<GrantType> authorizedGrantTypes;

    /**
     * 网址
     */
    @Column(nullable = false, length = 256)
    @NotNull(message = "网址不能为空!")
    @Description("网址")
    private String redirectUrl;

    /**
     * 授权角色
     */
    @Column(length = 256)
    @Description("授权角色")
    @Type(type = "com.isoft.ifx.domain.type.BitEnumSetType")
    @EnumType(type = "com.isoft.iuc.domain.enumeration.AuthorityRoleType")
    private EnumSet<AuthorityRoleType> authorities;

    /**
     * 令牌有效时间
     */
    @Description("令牌有效时间")
    private Integer accessTokenValidity;

    /**
     * 刷新令牌有效时间
     */
    @Description("刷新令牌有效时间")
    private Integer refreshTokenValidity;

    /**
     * 默认授权
     */
    @Description("默认授权")
    @Type(type = "com.isoft.ifx.domain.type.BitEnumSetType")
    @EnumType(type = "com.isoft.iuc.domain.enumeration.Scope")
    private EnumSet<Scope> autoApproveScopes;

    /**
     * 附加信息
     */
    @Description("附加信息")
    private HashMap<String, Object> additionalInformation;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public EnumSet<Scope> getScope() {
        return scope;
    }

    public void setScope(EnumSet<Scope> scope) {
        this.scope = scope;
    }

    public EnumSet<GrantType> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(EnumSet<GrantType> authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public EnumSet<AuthorityRoleType> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(EnumSet<AuthorityRoleType> authorities) {
        this.authorities = authorities;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public EnumSet<Scope> getAutoApproveScopes() {
        return autoApproveScopes;
    }

    public void setAutoApproveScopes(EnumSet<Scope> autoApproveScopes) {
        this.autoApproveScopes = autoApproveScopes;
    }

    public HashMap<String, Object> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(HashMap<String, Object> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
