package org.lostway.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.lostway.dto.UpdateOrderDto;
import org.lostway.enums.Currency;

import java.math.BigDecimal;

public class MaxAmountByCurrencyValidator implements ConstraintValidator<MaxAmountByCurrency, Object> {

    @Override
    public boolean isValid(Object dto, ConstraintValidatorContext context) {
        if (dto == null) return true;

        BigDecimal totalAmount;
        String currencyStr;

        if (dto instanceof UpdateOrderDto updateDto) {
            totalAmount = updateDto.totalAmount();
            currencyStr = updateDto.currency();
        } else {
            return true;
        }

        if (currencyStr == null || totalAmount == null) return true;

        Currency currency;
        try {
            currency = Currency.valueOf(currencyStr.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Недопустимая валюта: " + currencyStr)
                .addPropertyNode("currency")
                .addConstraintViolation();
            return false;
        }

        BigDecimal limit;
        switch (currency) {
            case RUB -> limit = new BigDecimal("100000");
            case EU -> limit = new BigDecimal("1800");
            case USD -> limit = new BigDecimal("2000");
            default -> {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Недопустимая валюта: " + currencyStr)
                    .addPropertyNode("currency")
                    .addConstraintViolation();
                return false;
            }
        }

        if (totalAmount.compareTo(limit) > 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Сумма превышает лимит для валюты " + currency)
                .addPropertyNode("totalAmount")
                .addConstraintViolation();
            return false;
        }

        return true;
    }
}

