package com.internship.array_task.spec;

import com.internship.array_task.model.IntArray;

public final class NameEqualsSpecification implements ArraySpecification {
    private final String expected;

    public NameEqualsSpecification(String expected) {
        this.expected = expected;
    }

    public boolean isSatisfiedBy(IntArray array) {
        if (expected == null) {
            return array.getName() == null;
        } else {
            String name = array.getName();
            return name != null && name.equals(expected);
        }
    }
}