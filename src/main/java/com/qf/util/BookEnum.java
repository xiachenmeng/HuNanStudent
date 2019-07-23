package com.qf.util;

public enum BookEnum {
    PAGE_SIZE(3),
    ROLE_PAGE_SIZE(5);

    private   Integer value;

    BookEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
