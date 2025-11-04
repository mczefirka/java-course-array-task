package com.internship.array_task.validation;

public final class RegexConstants {
    public static final String INTEGER_TOKEN = "-?\\d+";
    public static final String SEPARATORS = "[\\s\\p{Zs},;\\p{Pd}\\u2212]+";
    public static final String INTEGER_LIST = "^\\s*" + INTEGER_TOKEN + "(" + SEPARATORS + INTEGER_TOKEN + ")*\\s*$";

    private RegexConstants() {
    }
}