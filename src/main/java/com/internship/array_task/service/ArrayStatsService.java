package com.internship.array_task.service;

import com.internship.array_task.model.IntArray;

public interface ArrayStatsService {
    int min(IntArray array);
    int max(IntArray array);
    long sum(IntArray array);
    double average(IntArray array);
    int positiveCount(IntArray array);
    int negativeCount(IntArray array);
}