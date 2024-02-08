package com.test.application;

import com.test.application.models.Invoice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class InvoiceServiceTest {
    private final List<Invoice> inputs = Arrays.asList(
            new Invoice("EUR", new BigDecimal("50")),
            new Invoice("EUR", new BigDecimal("27")),
            null,
            new Invoice("EUR", new BigDecimal("36")),
            new Invoice("EUR", new BigDecimal("42")),
            null,
            new Invoice("EUR", new BigDecimal("39")),
            new Invoice("EUR", null),
            null);

    @Test
    void testFilterEvenNumbers() {
        var expected = Arrays.asList(new BigDecimal("36"), new BigDecimal("42"), new BigDecimal("50"));
        var result = InvoiceService.filterEvenNumbers(inputs);
        assertEquals(expected, result);
    }

    @Test
    void testDoubleNumbers() {
        var expected = Arrays.asList(new BigDecimal("100"), new BigDecimal("84"),
                new BigDecimal("78"), new BigDecimal("72"), new BigDecimal("54"));
        var result = InvoiceService.doubleNumbers(inputs);
        assertEquals(expected, result);
    }

    @Test
    void testSum() {
        var result = InvoiceService.sum(inputs);
        assertEquals(new BigDecimal("194"), result);
    }

    @Test
    void testGetMaxNumber() {
        var expected = new Invoice("EUR", new BigDecimal("50"));
        var result = InvoiceService.getMax(inputs);
        assertEquals(expected, result);
    }

    @Test
    void testGetMaxWithError() {
        assertThrows(IllegalArgumentException.class, () -> InvoiceService.getMax(Collections.emptyList()));
    }
}
