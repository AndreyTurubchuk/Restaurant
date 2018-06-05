package ru.topjava.restaurant.util;

public class DateTimeUtil {

    private DateTimeUtil() {
    }

    public static <T extends Comparable<? super T>> boolean isBetween(T value, T start, T end) {
        return value.compareTo(start) >= 0 && value.compareTo(end) <= 0;
    }
}
