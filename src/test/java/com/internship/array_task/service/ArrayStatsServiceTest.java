package com.internship.array_task.service;

import com.internship.array_task.exception.ArrayException;
import com.internship.array_task.model.IntArray;
import com.internship.array_task.service.impl.ArrayStatsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayStatsServiceTest {
    private final ArrayStatsService service = new ArrayStatsServiceImpl();

    @Test
    void min_returnsMinForMixedValues() {
        IntArray array = IntArray.of(1, -2, 3, 0);
        int result = service.min(array);
        Assertions.assertEquals(-2, result);
    }

    @Test
    void max_returnsMaxForMixedValues() {
        IntArray array = IntArray.of(1, -2, 3, 0);
        int result = service.max(array);
        Assertions.assertEquals(3, result);
    }

    @Test
    void sum_and_average_and_counts() {
        IntArray array = IntArray.of(1, -2, 3, 0);
        long sum = service.sum(array);
        double avg = service.average(array);
        int pos = service.positiveCount(array);
        int neg = service.negativeCount(array);
        Assertions.assertEquals(2L, sum);
        Assertions.assertEquals(0.5d, avg);
        Assertions.assertEquals(2, pos);
        Assertions.assertEquals(1, neg);
    }

    @Test
    void min_throwsForEmptyArray() {
        IntArray array = IntArray.empty();
        Assertions.assertThrows(ArrayException.class, () -> service.min(array));
    }

    @Test
    void max_throwsForEmptyArray() {
        IntArray array = IntArray.empty();
        Assertions.assertThrows(ArrayException.class, () -> service.max(array));
    }

    @Test
    void min_throwsForNullArray() {
        Assertions.assertThrows(ArrayException.class, () -> service.min(null));
    }

    @Test
    void max_throwsForNullArray() {
        Assertions.assertThrows(ArrayException.class, () -> service.max(null));
    }

    @Test
    void minAndMax_singleElement() {
        IntArray array = IntArray.of(5);
        int min = service.min(array);
        int max = service.max(array);
        Assertions.assertEquals(5, min);
        Assertions.assertEquals(5, max);
    }
}