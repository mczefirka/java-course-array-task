package com.internship.array_task.service;

import com.internship.array_task.model.IntArray;
import com.internship.array_task.service.impl.ArraySortServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class ArraySortServiceTest {
    private final ArraySortService service = new ArraySortServiceImpl();

    @Test
    void bubble_selection_insertion_sortProperly() {
        IntArray source = IntArray.of(3, 1, 4, 1, 5, 9, 2);
        int[] expected = source.toArray();
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, service.bubbleSort(source).toArray());
        Assertions.assertArrayEquals(expected, service.selectionSort(source).toArray());
        Assertions.assertArrayEquals(expected, service.insertionSort(source).toArray());
        Assertions.assertArrayEquals(new int[] {3, 1, 4, 1, 5, 9, 2}, source.toArray());
    }
}