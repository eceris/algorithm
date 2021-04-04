package eceris.programmers.search;

import java.util.*;
import java.util.stream.Collectors;

public class FindPrime {

    public static void main(String args[]) {

        System.out.println(solution("123"));
//        System.out.println(solution("17"));
//        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        return extracted(numbers);
    }

    private static int extracted(String numbers) {
        // 123
        // q : 1 2 3

        // 1 , 12, 123 -> into set
        // 123 -> 231

        // 231
        // q : 2 3 1
        // 2, 23, 231 -> into set
        // 231-> 312

        // 312
        // q : 3 1 2
        // 3, 31, 312 -> into set
        // 312 -> 123

        final Set<Integer> extracted = new HashSet<>();

        String tempForCompare = numbers;
        while (true) {
            tempForCompare = splitAndPutInBag(extracted, tempForCompare);
            if (numbers.equals(tempForCompare)) {
                break;
            }
        }
        long count = extracted.stream()
                .filter(i -> isPrimeNumber(i))
                .count();
        return Long.valueOf(count).intValue();
    }

    public static String splitAndPutInBag(Set<Integer> extracted, String target) {

        List<String> collect = Arrays.stream(target.split("")).collect(Collectors.toList());
        Queue<String> queue = new LinkedList<>(collect);

        String stackedNumber = "";
        while (queue.peek() != null) {
            Integer number = Integer.valueOf(stackedNumber + queue.poll());
            stackedNumber = number.toString();
            extracted.add(number);
        }

        //다음 숫자들을 찾기 위해 target 의 순서 변경
        return target.substring(1) + target.substring(0, 1);
    }


    public static Boolean isPrimeNumber(Integer num) {
        if (num < 2) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
