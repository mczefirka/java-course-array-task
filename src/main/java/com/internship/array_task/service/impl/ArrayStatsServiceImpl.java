package com.internship.array_task.service.impl;

import com.internship.array_task.exception.ArrayException;
import com.internship.array_task.model.IntArray;
import com.internship.array_task.service.ArrayStatsService;

public class ArrayStatsServiceImpl implements ArrayStatsService {
    public int min(IntArray array) {
        if (array != null) {
            int[] values = array.toArray();
            if (values.length > 0) {
                int result = values[0];
                for (int i = 1; i < values.length; i++) {
                    if (values[i] < result) {
                        result = values[i];
                    }
                }
                return result;
            } else {
                throw new ArrayException("array is empty");
            }
        } else {
            throw new ArrayException("array is null");
        }
    }

    public int max(IntArray array) {
        if (array != null) {
            int[] values = array.toArray();
            if (values.length > 0) {
                int result = values[0];
                for (int i = 1; i < values.length; i++) {
                    if (values[i] > result) {
                        result = values[i];
                    }
                }
                return result;
            } else {
                throw new ArrayException("array is empty");
            }
        } else {
            throw new ArrayException("array is null");
        }
    }

    public long sum(IntArray array) {
        if (array != null) {
            int[] values = array.toArray();
            long result = 0L;
            for (int i = 0; i < values.length; i++) {
                result += values[i];
            }
            return result;
        } else {
            throw new ArrayException("array is null");
        }
    }

    public double average(IntArray array) {
        if (array != null) {
            if (array.length() > 0) {
                long total = sum(array);
                return (double) total / (double) array.length();
            } else {
                throw new ArrayException("array is empty");
            }
        } else {
            throw new ArrayException("array is null");
        }
    }

    public int positiveCount(IntArray array) {
        if (array != null) {
            int[] values = array.toArray();
            int result = 0;
            for (int i = 0; i < values.length; i++) {
                if (values[i] > 0) {
                    result++;
                }
            }
            return result;
        } else {
            throw new ArrayException("array is null");
        }
    }

    public int negativeCount(IntArray array) {
        if (array != null) {
            int[] values = array.toArray();
            int result = 0;
            for (int i = 0; i < values.length; i++) {
                if (values[i] < 0) {
                    result++;
                }
            }
            return result;
        } else {
            throw new ArrayException("array is null");
        }
    }
}