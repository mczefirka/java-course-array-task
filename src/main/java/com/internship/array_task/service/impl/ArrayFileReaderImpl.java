package com.internship.array_task.service.impl;

import com.internship.array_task.exception.ArrayException;
import com.internship.array_task.model.IntArray;
import com.internship.array_task.service.ArrayFileReader;
import com.internship.array_task.validation.ArrayLineValidator;
import com.internship.array_task.validation.RegexConstants;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayFileReaderImpl implements ArrayFileReader {
    private final ArrayLineValidator validator = new ArrayLineValidator();
    private final Pattern split = Pattern.compile(RegexConstants.SEPARATORS);
    private final Pattern intToken = Pattern.compile(RegexConstants.INTEGER_TOKEN);

    public List<IntArray> read(Path relativePath) {
        if (relativePath != null) {
            Path path = relativePath;
            List<IntArray> result = new ArrayList<>();
            List<String> lines;
            try {
                lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new ArrayException("file read error", e);
            }
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line != null && line.isEmpty()) {
                    continue;
                }
                if (validator.isValid(line)) {
                    String trimmed = line == null ? "" : line.trim();
                    if (trimmed.isEmpty()) {
                        result.add(IntArray.empty());
                    } else {
                        String normalized = trimmed.replace('\u2013', '-').replace('\u2014', '-').replace('\u2212', '-');
                        Matcher m = intToken.matcher(normalized);
                        List<Integer> nums = new ArrayList<>();
                        while (m.find()) {
                            String t = m.group();
                            if (t != null && !t.isEmpty() && t.charAt(0) == '\uFEFF') {
                                t = t.substring(1);
                            }
                            nums.add(Integer.parseInt(t));
                        }
                        int[] values = new int[nums.size()];
                        for (int j = 0; j < nums.size(); j++) {
                            values[j] = nums.get(j);
                        }
                        result.add(IntArray.of(values));
                    }
                }
            }
            return result;
        } else {
            throw new ArrayException("path is null");
        }
    }
}