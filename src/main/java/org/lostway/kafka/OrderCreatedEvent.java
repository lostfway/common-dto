package org.lostway.kafka;

import org.lostway.enums.Currency;
import org.lostway.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record OrderCreatedEvent(
    OrderCreatedMeta meta,
    OrderStatus eventType,
    Instant createdAt,
    OrderCreatedPayload payload
) {
    public record OrderCreatedMeta(
        String producer
    ) {}

    public record OrderCreatedPayload(
        Currency currency,
        UUID orderId,
        UUID userId,
        UUID sellerId,
        BigDecimal totalAmount,
        List<OrderCreatedItem> items
    ) {
        public record OrderCreatedItem(
            UUID sku,
            BigDecimal price
        ) {}
    }
}
