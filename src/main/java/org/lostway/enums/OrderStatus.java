package org.lostway.enums;

public enum OrderStatus {
    CREATED,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED;

    public String toValue() {
        return name().toLowerCase();
    }
}
