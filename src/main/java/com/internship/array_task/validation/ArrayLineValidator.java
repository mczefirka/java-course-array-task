package com.internship.array_task.validation;

import java.util.regex.Pattern;

public final class ArrayLineValidator {
    private final Pattern pattern = Pattern.compile(RegexConstants.INTEGER_LIST);

    public boolean isValid(String line) {
        if (line != null) {
            String value = line;
            return value.trim().isEmpty() || pattern.matcher(value).matches();
        } else {
            return false;
        }
    }
}