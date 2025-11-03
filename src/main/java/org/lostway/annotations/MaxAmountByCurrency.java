package org.lostway.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MaxAmountByCurrencyValidator.class)
public @interface MaxAmountByCurrency {
    String message() default "Сумма превышает лимит для выбранной валюты";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

