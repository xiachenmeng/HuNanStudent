package com.qf.util;

public enum ClassEnum {
    PAGE_SIZE(3);
    private   Integer value;

    ClassEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
