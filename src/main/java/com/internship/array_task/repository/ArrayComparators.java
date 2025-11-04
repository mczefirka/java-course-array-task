package com.internship.array_task.repository;

import com.internship.array_task.model.IntArray;
import java.util.Comparator;

public final class ArrayComparators {
    public static final Comparator<IntArray> BY_NAME = new Comparator<IntArray>() {
        public int compare(IntArray a, IntArray b) {
            String an = a.getName();
            String bn = b.getName();
            if (an == null && bn == null) return 0;
            if (an == null) return -1;
            if (bn == null) return 1;
            return an.compareTo(bn);
        }
    };

    public static final Comparator<IntArray> BY_FIRST_ELEMENT = new Comparator<IntArray>() {
        public int compare(IntArray a, IntArray b) {
            int av = a.length() == 0 ? Integer.MIN_VALUE : a.toArray()[0];
            int bv = b.length() == 0 ? Integer.MIN_VALUE : b.toArray()[0];
            return Integer.compare(av, bv);
        }
    };

    public static final Comparator<IntArray> BY_LENGTH = new Comparator<IntArray>() {
        public int compare(IntArray a, IntArray b) {
            return Integer.compare(a.length(), b.length());
        }
    };

    private ArrayComparators() {
    }
}