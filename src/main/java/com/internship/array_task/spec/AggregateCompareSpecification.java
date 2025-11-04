package com.internship.array_task.spec;

import com.internship.array_task.model.IntArray;
import com.internship.array_task.service.ArrayStatsService;

public final class AggregateCompareSpecification implements ArraySpecification {
    public enum Metric { SUM, AVG, MIN, MAX, LEN }
    public enum Op { GT, LT, EQ }

    private final ArrayStatsService stats;
    private final Metric metric;
    private final Op op;
    private final double expected;

    public AggregateCompareSpecification(ArrayStatsService stats, Metric metric, Op op, double expected) {
        this.stats = stats;
        this.metric = metric;
        this.op = op;
        this.expected = expected;
    }

    public boolean isSatisfiedBy(IntArray array) {
        double actual;
        if (metric == Metric.SUM) {
            actual = stats.sum(array);
        } else if (metric == Metric.AVG) {
            actual = stats.average(array);
        } else if (metric == Metric.MIN) {
            actual = stats.min(array);
        } else if (metric == Metric.MAX) {
            actual = stats.max(array);
        } else {
            actual = array.length();
        }
        if (op == Op.GT) {
            return actual > expected;
        } else if (op == Op.LT) {
            return actual < expected;
        } else {
            return actual == expected;
        }
    }
}