package com.example.hr.domain;

import com.example.hr.domain.annotation.ValueObject;

import java.util.Objects;

@ValueObject
public class Money {
    private final double value;
    private final FiatCurrency curreny;

    private Money(double value, FiatCurrency curreny) {
        this.value = value;
        this.curreny = curreny;
    }

    public static Money of(double value, FiatCurrency currency) {
        if(value < 0.0) {
            throw new IllegalArgumentException("Value must be zero or positive.");
        }
        Objects.requireNonNull(currency, "Currency must be given");
        return new Money(value, currency);
    }

    public static Money of(double value) {
        return Money.of(value, FiatCurrency.TRY);
    }

    public double getValue() {
        return value;
    }

    public FiatCurrency getCurreny() {
        return curreny;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.value, value) == 0 &&
                curreny == money.curreny;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, curreny);
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", curreny=" + curreny +
                '}';
    }
}
