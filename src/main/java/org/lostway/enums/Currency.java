package org.lostway.enums;

public enum Currency {
    RUB,
    EU,
    USD;

    public String toValue() {
        return name().toLowerCase();
    }
}
