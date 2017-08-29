package com.isoft.iuc.domain.enumeration;

import com.isoft.ifx.core.enumeration.BitEnum;
import com.isoft.ifx.core.enumeration.EnumDescriptor;

/**
 * 用户状态
 * Created by liuqiang03 on 2017/6/22.
 */
@EnumDescriptor(name = "user_status",text = "用户状态",description = "用户状态枚举")
public enum UserStatus implements BitEnum {
    ACTIVE("有效", 1), INACTIVE("无效", 2);

    private String text;
    private long value;

    UserStatus(String text, long value) {
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
