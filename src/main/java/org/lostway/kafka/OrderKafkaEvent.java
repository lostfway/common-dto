package org.lostway.kafka;

import org.lostway.enums.Currency;
import org.lostway.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record OrderKafkaEvent(
    UUID orderId,
    UUID userId,
    UUID sellerId,
    UUID paymentId,
    UUID shipmentId,
    OrderStatus status,
    BigDecimal totalAmount,
    Currency currency,
    List<OrderItemKafkaEvent> items,
    Instant slaDeadline,
    Instant createdAt,
    Instant updatedAt
) {
    public record OrderItemKafkaEvent(
        UUID sku,
        BigDecimal price
    ) {
    }
}