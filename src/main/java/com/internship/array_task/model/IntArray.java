package com.internship.array_task.model;

import com.internship.array_task.exception.ArrayException;
import java.util.Arrays;

public final class IntArray {
    private final int[] values;
    private final String name;

    private IntArray(int[] values, String name) {
        this.values = values;
        this.name = name;
    }

    public static IntArray of(int... values) {
        if (values != null) {
            int[] copy = Arrays.copyOf(values, values.length);
            return new IntArray(copy, null);
        } else {
            throw new ArrayException("values is null");
        }
    }

    public static IntArray named(String name, int... values) {
        if (values != null) {
            int[] copy = Arrays.copyOf(values, values.length);
            return new IntArray(copy, name);
        } else {
            throw new ArrayException("values is null");
        }
    }

    public static IntArray empty() {
        return new IntArray(new int[0], null);
    }

    public int length() {
        return values.length;
    }

    public int[] toArray() {
        return Arrays.copyOf(values, values.length);
    }

    public String getName() {
        return name;
    }
}