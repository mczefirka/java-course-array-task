package com.internship.array_task.service;

import com.internship.array_task.model.IntArray;
import java.util.function.IntPredicate;

public interface ArrayReplaceService {
    IntArray replaceWhere(IntArray array, IntPredicate condition, int newValue);
}