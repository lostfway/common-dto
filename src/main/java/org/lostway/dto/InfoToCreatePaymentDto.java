package org.lostway.dto;

import org.lostway.enums.Currency;

import java.math.BigDecimal;
import java.util.UUID;

public record InfoToCreatePaymentDto(
    UUID id,
    UUID userId,
    BigDecimal amount,
    Currency currency
) {
}
