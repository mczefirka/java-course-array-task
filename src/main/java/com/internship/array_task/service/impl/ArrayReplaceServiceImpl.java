package com.internship.array_task.service.impl;

import com.internship.array_task.exception.ArrayException;
import com.internship.array_task.model.IntArray;
import com.internship.array_task.service.ArrayReplaceService;
import java.util.function.IntPredicate;

public class ArrayReplaceServiceImpl implements ArrayReplaceService {
    public IntArray replaceWhere(IntArray array, IntPredicate condition, int newValue) {
        if (array != null) {
            if (condition != null) {
                int[] source = array.toArray();
                int[] copy = new int[source.length];
                for (int i = 0; i < source.length; i++) {
                    if (condition.test(source[i])) {
                        copy[i] = newValue;
                    } else {
                        copy[i] = source[i];
                    }
                }
                return IntArray.of(copy);
            } else {
                throw new ArrayException("condition is null");
            }
        } else {
            throw new ArrayException("array is null");
        }
    }
}