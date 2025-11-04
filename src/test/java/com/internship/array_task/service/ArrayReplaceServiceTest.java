package com.internship.array_task.service;

import com.internship.array_task.model.IntArray;
import com.internship.array_task.service.impl.ArrayReplaceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.function.IntPredicate;

class ArrayReplaceServiceTest {
    private final ArrayReplaceService service = new ArrayReplaceServiceImpl();

    @Test
    void replaceWhere_replacesNegativesWithZero() {
        IntArray source = IntArray.of(1, -2, 3, -4, 0);
        IntPredicate isNegative = new IntPredicate() {
            public boolean test(int value) {
                return value < 0;
            }
        };
        IntArray result = service.replaceWhere(source, isNegative, 0);
        int[] expected = new int[] {1, 0, 3, 0, 0};
        Assertions.assertArrayEquals(expected, result.toArray());
        Assertions.assertArrayEquals(new int[] {1, -2, 3, -4, 0}, source.toArray());
    }
}