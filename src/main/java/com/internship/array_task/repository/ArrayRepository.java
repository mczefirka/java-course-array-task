package com.internship.array_task.repository;

import com.internship.array_task.model.IntArray;
import com.internship.array_task.spec.ArraySpecification;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class ArrayRepository {
    private static ArrayRepository instance;
    private final List<IntArray> storage = new ArrayList<>();
    private final List<RepositoryObserver> observers = new ArrayList<>();

    private ArrayRepository() {
    }

    public static ArrayRepository getInstance() {
        if (instance == null) {
            instance = new ArrayRepository();
        }
        return instance;
    }

    public void add(IntArray array) {
        if (array != null) {
            storage.add(array);
            notifySaved(array);
        }
    }

    public boolean remove(IntArray array) {
        if (array != null) {
            boolean removed = storage.remove(array);
            if (removed) {
                notifyDeleted(array);
            }
            return removed;
        } else {
            return false;
        }
    }

    public boolean update(IntArray oldArray, IntArray newArray) {
        if (oldArray != null) {
            int idx = storage.indexOf(oldArray);
            if (idx >= 0) {
                storage.set(idx, newArray);
                notifyDeleted(oldArray);
                notifySaved(newArray);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public List<IntArray> findAll() {
        return Collections.unmodifiableList(storage);
    }

    public void clear() {
        storage.clear();
    }

    public List<IntArray> query(ArraySpecification specification) {
        if (specification != null) {
            List<IntArray> result = new ArrayList<>();
            for (int i = 0; i < storage.size(); i++) {
                IntArray array = storage.get(i);
                if (specification.isSatisfiedBy(array)) {
                    result.add(array);
                }
            }
            return result;
        } else {
            return List.of();
        }
    }

    public List<IntArray> sort(Comparator<IntArray> comparator) {
        List<IntArray> copy = new ArrayList<>(storage);
        if (comparator != null) {
            copy.sort(comparator);
        }
        return copy;
    }

    public void registerObserver(RepositoryObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    public void unregisterObserver(RepositoryObserver observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    private void notifySaved(IntArray array) {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).onSaved(array);
        }
    }

    private void notifyDeleted(IntArray array) {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).onDeleted(array);
        }
    }
}