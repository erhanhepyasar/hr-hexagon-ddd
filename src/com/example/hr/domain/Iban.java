package com.example.hr.domain;

import com.example.hr.domain.annotation.ValueObject;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

@ValueObject
public final class Iban {
    private final String value;

    private Iban(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Iban valueOf(String value) {
        if(!isValid(value)) {
            throw new IllegalArgumentException("This is not a valid iban!");
        }

        return new Iban(value);
    }

    private static boolean isValid(String iban) {
        return iban.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Iban iban = (Iban) o;
        return Objects.equals(value, iban.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Iban{" +
                "value='" + value + '\'' +
                '}';
    }
}
