package org.lostway.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.lostway.annotations.MaxAmountByCurrency;
import org.lostway.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@MaxAmountByCurrency
public record UpdateOrderDto(
    @NotNull UUID id,
    @NotNull UUID userId,
    UUID externalId,
    UUID sellerId,
    OrderStatus status,
    String paymentId,
    String shipmentId,
    Instant slaDeadline,
    Instant createdAt,
    Instant updatedAt,
    @NotEmpty @Size(min = 1) List<ItemDto> items,
    @NotNull @DecimalMin("0.01") BigDecimal totalAmount,
    @NotBlank String currency
) {
}
