package com.eceris.hackerrank.warmup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://www.hackerrank.com/challenges/time-conversion/problem

public class TimeConversion {
    public static void main(String[] args) {
        String s = "12:45:54AM";
        System.out.println(timeConversion(s));
    }

    private static String timeConversion(String s) {
        Matcher timeMatcher = Pattern.compile("[0-9]{2}").matcher(s);
        Matcher ampmMatcher = Pattern.compile("[A-Z]{2}").matcher(s);
        String[] time = new String[3];
        int i = 0;
        String ampm = "";
        while (ampmMatcher.find()) {
            ampm = ampmMatcher.group();
        }
        while (timeMatcher.find()) {
            time[i++] = timeMatcher.group();
        }

        if (ampm.equals("AM")) {
            int hour = Integer.valueOf(time[0]) % 12;
            time[0] = String.format("%02d", hour);

        } else {
            int hour = Integer.valueOf(time[0]) % 12 + Integer.valueOf(12);
            time[0] = String.format("%02d", hour);
        }

        return String.join(":", time);
    }
}
