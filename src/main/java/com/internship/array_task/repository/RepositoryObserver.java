package com.internship.array_task.repository;

import com.internship.array_task.model.IntArray;

public interface RepositoryObserver {
    void onSaved(IntArray array);
    void onDeleted(IntArray array);
}