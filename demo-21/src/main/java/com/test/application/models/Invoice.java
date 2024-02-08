package com.test.application.models;

import java.math.BigDecimal;

public record Invoice(
        String currency,
        BigDecimal amount
) {
}
