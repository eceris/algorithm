package eceris.goorm;

import java.util.ArrayList;
import java.util.List;

public class GetDivisor {
    public static void main(String[] args) {
        calc(20);
    }
    public static void calc(int num) {
        List<String> values = new ArrayList<>();
        for (int i = 1; i <= num ; i++) {
            if (num % i == 0) {
                values.add(String.valueOf(i));
            }
        }
        System.out.println(String.join(" ", values));
    }
}
