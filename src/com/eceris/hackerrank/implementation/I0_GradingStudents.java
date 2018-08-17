package com.eceris.hackerrank.implementation;

import java.util.stream.IntStream;

//https://www.hackerrank.com/challenges/grading/problem
public class I0_GradingStudents {
    public static void main(String[] args) {
//        int[] grades = {73, 67, 38, 33};
        int[] grades = {80, 96, 18, 73, 78, 60, 60, 15, 45, 15, 10, 5, 46, 87, 33, 60, 14, 71, 65, 2, 5, 97, 0};
        IntStream.of(gradingStudents(grades)).forEach(System.out::println);
    }

    static int[] gradingStudents(int[] grades) {
        /*
         * Write your code here.
         */
        int[] rounded = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            rounded[i] = getRoundedGrade(grades[i]);
        }

        return rounded;
    }

    static int getRoundedGrade(int grade) {
        if (grade < 38) {
            return grade;
        }
        int remained = grade % 5;

        int multiple5ofHigh = grade + 5 - remained;

        int remainedOfMultiple5 = (multiple5ofHigh - grade) % 5;
        if (remainedOfMultiple5 > 0 && remainedOfMultiple5 < 3) {
            return multiple5ofHigh;
        } else {
            return grade;
        }
    }
}
