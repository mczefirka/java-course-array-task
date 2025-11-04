package com.internship.array_task.service;

import com.internship.array_task.model.IntArray;
import com.internship.array_task.service.impl.ArrayFileReaderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.List;

class ArrayFileReaderTest {
    private final ArrayFileReader reader = new ArrayFileReaderImpl();

    @Test
    void read_parsesValidLinesAndSkipsInvalid() {
        Path path = Path.of("data/test_arrays.txt");
        List<IntArray> arrays = reader.read(path);
        Assertions.assertEquals(5, arrays.size());
        Assertions.assertArrayEquals(new int[] {1, 2, 3}, arrays.get(0).toArray());
        Assertions.assertArrayEquals(new int[] {11, 2}, arrays.get(1).toArray());
        Assertions.assertArrayEquals(new int[] {}, arrays.get(2).toArray());
        Assertions.assertArrayEquals(new int[] {-1, -2, -3}, arrays.get(3).toArray());
        Assertions.assertArrayEquals(new int[] {4, 5, 6}, arrays.get(4).toArray());
    }
}