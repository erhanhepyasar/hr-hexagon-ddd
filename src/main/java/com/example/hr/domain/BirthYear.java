package com.example.hr.domain;

import com.example.hr.domain.annotation.ValueObject;

import java.util.Objects;

@ValueObject
public class BirthYear {
    private final int value;

    private BirthYear(int value) {
        this.value = value;
    }

    public static BirthYear valueOf(int value) {
        if(value < 1950)
            throw new IllegalArgumentException("Year must be larger than 1950.");

        return new BirthYear(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthYear birthYear = (BirthYear) o;
        return value == birthYear.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "BirthYear{" +
                "value=" + value +
                '}';
    }
}
