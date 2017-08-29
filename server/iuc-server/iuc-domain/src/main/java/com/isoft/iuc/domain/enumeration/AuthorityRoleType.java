package com.isoft.iuc.domain.enumeration;

import com.isoft.ifx.core.enumeration.BitEnum;
import com.isoft.ifx.core.enumeration.EnumDescriptor;

/**
 * 授权角色类型
 * Created by liuqiang03 on 2017/6/23.
 */
@EnumDescriptor(name = "AuthorityRoleType",text = "授权角色类型",description = "测试")
public enum AuthorityRoleType implements BitEnum {
    ROLE_CLIENT("客户端", 1);

    private String text;
    private long value;

    AuthorityRoleType(String text, long value) {
        this.text = text;
        this.value = value;
    }

    @Override
    public long getValue() {
        return this.value;
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
