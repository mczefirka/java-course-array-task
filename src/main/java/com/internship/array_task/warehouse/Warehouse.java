package com.internship.array_task.warehouse;

import com.internship.array_task.model.IntArray;
import com.internship.array_task.repository.ArrayRepository;
import com.internship.array_task.repository.RepositoryObserver;
import com.internship.array_task.service.ArrayStatsService;
import com.internship.array_task.service.impl.ArrayStatsServiceImpl;
import java.util.HashMap;
import java.util.Map;

public final class Warehouse implements RepositoryObserver {
    private static Warehouse instance;
    private final Map<IntArray, ArrayMetrics> metrics = new HashMap<>();
    private final ArrayStatsService stats = new ArrayStatsServiceImpl();

    private Warehouse() {
        ArrayRepository.getInstance().registerObserver(this);
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public ArrayMetrics getMetrics(IntArray array) {
        return metrics.get(array);
    }

    public void onSaved(IntArray array) {
        long sum = stats.sum(array);
        double avg = array.length() == 0 ? 0.0 : stats.average(array);
        int min = array.length() == 0 ? 0 : stats.min(array);
        int max = array.length() == 0 ? 0 : stats.max(array);
        metrics.put(array, new ArrayMetrics(sum, avg, min, max));
    }

    public void onDeleted(IntArray array) {
        metrics.remove(array);
    }

    public void clear() {
        metrics.clear();
    }
}