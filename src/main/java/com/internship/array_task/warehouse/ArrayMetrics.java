package com.internship.array_task.warehouse;

public final class ArrayMetrics {
    private final long sum;
    private final double average;
    private final int min;
    private final int max;

    public ArrayMetrics(long sum, double average, int min, int max) {
        this.sum = sum;
        this.average = average;
        this.min = min;
        this.max = max;
    }

    public long getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}


