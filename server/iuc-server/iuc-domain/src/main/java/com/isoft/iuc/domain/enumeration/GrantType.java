package com.isoft.iuc.domain.enumeration;

import com.isoft.ifx.core.enumeration.BitEnum;

/**
 * 授权类型
 * Created by liuqiang03 on 2017/6/22.
 */
public enum GrantType implements BitEnum {
    AUTHORIZATION_CODE("授权码模式", 1),
    IMPLICIT("简化模式", 2),
    PASSWORD("密码模式", 4),
    CLIENT_CREDENTIALS("客户端模式", 8),
    REFRESH_TOKEN("刷新",16);

    private String text;
    private long value;

    GrantType(String text, long value) {
        this.text = text;
        this.value = value;
    }

    @Override
    public long getValue() {
        return value;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public String getName() {
        return this.name();
    }
}
