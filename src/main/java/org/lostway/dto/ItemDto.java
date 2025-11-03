package org.lostway.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemDto(
    @NotBlank UUID sku,
    @NotNull BigDecimal price
) {}
