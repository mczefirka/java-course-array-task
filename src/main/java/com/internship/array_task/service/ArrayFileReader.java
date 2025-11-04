package com.internship.array_task.service;

import com.internship.array_task.model.IntArray;

import java.nio.file.Path;
import java.util.List;

public interface ArrayFileReader {
    List<IntArray> read(Path relativePath);
}