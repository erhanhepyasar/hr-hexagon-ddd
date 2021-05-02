package com.example.hr.domain;

import com.example.hr.domain.annotation.ValueObject;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

// Value Object  i) no identity, ii) immutable
@ValueObject
public class TcKimlikNo {
    private final String value;
    private static final Map<String, TcKimlikNo> identityCache = new WeakHashMap<>();

    private TcKimlikNo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TcKimlikNo valueOf(String value) {
        if(!isValid(value)) {
            throw new IllegalArgumentException("This is not a valid identity no!");
        }
        // object pooling -> caching
        var tcKimlikNo = identityCache.get(value);
        if(Objects.nonNull(tcKimlikNo))
            return tcKimlikNo;

        tcKimlikNo = new TcKimlikNo(value);
        identityCache.put(value, tcKimlikNo);

        return new TcKimlikNo(value);
    }

    private static boolean isValid(String tckn) {
        boolean isValid = false;
        if (tckn != null && tckn.length() == 11 && isInt(tckn)) {
            long aTcNo, bTcNo, tcNo;
            long n1, n2, n3, n4, n5, n6, n7, n8, n9, control1, control2;
            tcNo = Long.parseLong(tckn);
            aTcNo = tcNo / 100;
            bTcNo = tcNo / 100;
            n1 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n2 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n3 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n4 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n5 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n6 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n7 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n8 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n9 = aTcNo % 10;
            control1 = ((10 - ((((n1 + n3 + n5 + n7 + n9) * 3) + (n2 + n4 + n6 + n8)) % 10)) % 10);
            control2 = ((10 - (((((n2 + n4 + n6 + n8) + control1) * 3) + (n1 + n3 + n5 + n7 + n9)) % 10)) % 10);
            isValid = ((bTcNo * 100) + (control1 * 10) + control2 == tcNo);
        }
        return isValid;
    }

    private static boolean isInt(String s)  // assuming integer is in decimal number system
    {
        for (int a = 0; a < s.length(); a++) {
            if (a == 0 && s.charAt(a) == '-') continue;
            if (!Character.isDigit(s.charAt(a))) return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TcKimlikNo that = (TcKimlikNo) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "TcKimlikNo{" +
                "value='" + value + '\'' +
                '}';
    }
}
