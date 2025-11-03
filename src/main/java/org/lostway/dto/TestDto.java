package org.lostway.dto;

import java.util.UUID;

public record TestDto(
    String message,
    UUID id
) {
}
