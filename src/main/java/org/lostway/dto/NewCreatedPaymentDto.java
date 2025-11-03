package org.lostway.dto;

import org.lostway.enums.PaymentStatus;

import java.util.UUID;

public record NewCreatedPaymentDto(
    UUID paymentId,
    PaymentStatus status
) {
}