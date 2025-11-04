package com.internship.array_task.service.impl;

import com.internship.array_task.exception.ArrayException;
import com.internship.array_task.model.IntArray;
import com.internship.array_task.service.ArraySortService;

public class ArraySortServiceImpl implements ArraySortService {
    public IntArray bubbleSort(IntArray array) {
        if (array != null) {
            int[] source = array.toArray();
            int[] a = new int[source.length];
            for (int i = 0; i < source.length; i++) {
                a[i] = source[i];
            }
            boolean swapped = true;
            int n = a.length;
            while (swapped) {
                swapped = false;
                for (int i = 1; i < n; i++) {
                    if (a[i - 1] > a[i]) {
                        int t = a[i - 1];
                        a[i - 1] = a[i];
                        a[i] = t;
                        swapped = true;
                    }
                }
                n = n - 1;
            }
            return IntArray.of(a);
        } else {
            throw new ArrayException("array is null");
        }
    }

    public IntArray selectionSort(IntArray array) {
        if (array != null) {
            int[] source = array.toArray();
            int[] a = new int[source.length];
            for (int i = 0; i < source.length; i++) {
                a[i] = source[i];
            }
            for (int i = 0; i < a.length - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] < a[minIdx]) {
                        minIdx = j;
                    }
                }
                if (minIdx != i) {
                    int t = a[i];
                    a[i] = a[minIdx];
                    a[minIdx] = t;
                }
            }
            return IntArray.of(a);
        } else {
            throw new ArrayException("array is null");
        }
    }

    public IntArray insertionSort(IntArray array) {
        if (array != null) {
            int[] source = array.toArray();
            int[] a = new int[source.length];
            for (int i = 0; i < source.length; i++) {
                a[i] = source[i];
            }
            for (int i = 1; i < a.length; i++) {
                int key = a[i];
                int j = i - 1;
                while (j >= 0 && a[j] > key) {
                    a[j + 1] = a[j];
                    j = j - 1;
                }
                a[j + 1] = key;
            }
            return IntArray.of(a);
        } else {
            throw new ArrayException("array is null");
        }
    }
}