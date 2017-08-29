package com.isoft.iuc.domain.enumeration;

import com.isoft.ifx.core.enumeration.BitEnum;

/**
 * 授权范围
 * Created by liuqiang03 on 2017/6/22.
 */
public enum Scope implements BitEnum {
    READ("读", 1),
    WRITE("写", 2),
    TRUST("信任", 4);

    private String text;
    private long value;

    Scope(String text, long value) {
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
