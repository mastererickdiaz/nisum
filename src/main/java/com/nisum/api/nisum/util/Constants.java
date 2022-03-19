package com.nisum.api.nisum.util;

public class Constants {
    public static final String DIGIT = "(?=.*[0-9])";
    public static final String LOWER_CASE = "(?=.*[a-z])";
    public static final String UPPER_CASE = "(?=.*[A-Z])";
    public static final String SPECIAL = "(?=.*[@#$%^&+=])";
    public static final String NO_BLAN_SPACE = "(?=\\S+$)";
    public static final String ANY = ".";
    public static final String SIZE = "{8,20}";

    public static final String PASSWORD =
            "^" + DIGIT + LOWER_CASE + UPPER_CASE + SPECIAL + NO_BLAN_SPACE + ANY + SIZE + "$";

}
