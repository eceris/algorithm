package eceris.etc.algospot.starter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Festival {

    public static final Scanner SCN = new Scanner(System.in);
    public static final List<Double> RESULT = new ArrayList<>();

    public static void main(String[] args) {

        int testCase = Integer.parseInt(SCN.nextLine());

        for(int i=0 ; i <testCase ; i++) {
            List<Long> data = new ArrayList<>();
            String[] condition = SCN.nextLine().split(" ");
            int days = Integer.parseInt(condition[0]);
            int teams = Integer.parseInt(condition[1]);

            String[] costs = SCN.nextLine().split(" ");
            for (String cost : costs) {
                data.add(Long.parseLong(cost));
            }
            RESULT.add(divide(teams, days, data));
        }
        for(Double r : RESULT) {
            System.out.println(String.format("%.10f", r));
        }
    }

    public static double divide(int min, int max, List<Long> data) {

        double result = -1;
        if (data.size() < max) {
            //count 의 최대값 제한
            max = data.size();
        }
        for(int i = 0; i < data.size() ; i++) {
            int count = 1;
            long sum = data.get(i);
            for(int j = i+1; j < data.size() ; j++) {
                sum += data.get(j);
                count++;
                if (count >= min || count == max) {
                    double temp = sum / (double)count;
                    if (result == -1 || temp < result) {
                        //결과의 최소값을 저장
                        result = temp;
                    }
//                    System.out.println(String.format("%.10f", temp));
                }
            }
        }
        return result;
    }
}
