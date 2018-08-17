package com.eceris.hackerrank.implementation;

// https://www.hackerrank.com/challenges/day-of-the-programmer/problem
public class I3_DayOfTheProgrammer {
    public static void main(String[] args) {
//        int year = 2017; //13.09.2017
//        int year = 2016; //12.09.2016
//        int year = 1800; //12.09.1800
//        int year = 2000; //12.09.2000
        int year = 1918; //26.09.1918

        String solve = solve(year);
        System.out.println(solve);
    }

    // Complete the solve function below.
    static String solve(int year) {
        if (year < 1699 || year > 2701) {
            throw new IllegalArgumentException();
        }
        int dayOfProgrammer = isLeap(year) ? 255 : 256;
        dayOfProgrammer = year == 1918 ? 269 : dayOfProgrammer;
        int dayOfMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 0; i < dayOfMonth.length; i++) {
            dayOfProgrammer = dayOfProgrammer - dayOfMonth[i];
            if (dayOfProgrammer < 0) {
                int month = i + 1;
                int day = dayOfMonth[i] + dayOfProgrammer;
                return String.format("%02d", day) + "." + String.format("%02d", month) + "." + year;
            }
        }

        return "";
    }

    static boolean isJulian(int year) {
        return year < 1918;
    }

    static boolean isLeap(int year) {
        if (isJulian(year)) {
            return year % 4 == 0;
        } else {
            if (year % 400 == 0) {
                return true;
            } else if(year % 4 == 0) {
                if (year % 100 == 0) {
                    return false;
                }
                return true;
            }

        }
        return false;
    }
}
