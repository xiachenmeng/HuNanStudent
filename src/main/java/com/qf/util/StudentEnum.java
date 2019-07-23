package com.qf.util;

public enum StudentEnum {
    PAGE_SIZE(3);
    private   Integer value;

     StudentEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
