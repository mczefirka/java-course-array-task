package com.internship.array_task.service;

import com.internship.array_task.model.IntArray;

public interface ArraySortService {
    IntArray bubbleSort(IntArray array);
    IntArray selectionSort(IntArray array);
    IntArray insertionSort(IntArray array);
}