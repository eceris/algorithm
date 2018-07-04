package com.eceris.String;
//    https://www.hackerrank.com/challenges/reduced-string/problem

import java.util.*;

public class SuperReducedString {
    public static void main(String[] args) {
        String[] split = "abba".split("");
        List<String> target = Arrays.asList(split);

        int index = 0;
        while (true) {
            if (isRightDuplicated(target, index)) {
                target.set(index, "0");
                target.set(index+1, "0");
            }
            if (isLeftDuplicated(target, index)) {
                target.set(index-1, "0");
                target.set(index, "0");
            }
            index++;
            List<String> temp = vacuum(target);
            target = temp;
        }
    }

    // 0 을 제거
    static List<String> vacuum(List<String> target) {
        List<String> result = new ArrayList<>();
        for(String s: target) {
            if (!s.equals("0")) {
                result.add(s);
            }
        }
        return result;
    }
    static boolean isLeftDuplicated(List<String> target, int index) {
        if (index <= 0) {
            return false;
        } else {
            return target.get(index).equals(target.get(index - 1));
        }
    }

    static boolean isRightDuplicated(List<String> target, int index) {
        if (index + 1 >= target.size()) {
            return false;
        } else {
            return target.get(index).equals(target.get(index + 1));
        }
    }

    // Complete the super_reduced_string function below.
    static String super_reduced_string(String s) {
        List<String> target = Arrays.asList(s);
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : target) {
            if (map.get(str) == null) {
                map.put(str, 1);
            } else {
                Integer integer = map.get(str);
                map.put(str, ++integer);
            }
        }

        if (map.size() == 0) {
            return "Empty String";
        }
        StringBuffer sb = new StringBuffer();
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            if (next.getValue() % 2 != 0) {
                sb.append(next.getKey());
            }
        }
        return sb.toString();
    }

}
