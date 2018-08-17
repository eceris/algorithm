package com.eceris.hackerrank.string;

//    https://www.hackerrank.com/challenges/reduced-string/problem

import java.util.*;

public class SuperReducedString_LinkedList {
    public static void main(String[] args) {
        String target = "kagoyzkgfjnyvjewazalxngpdcfahneqoqgiyjgpzobhaghmgzmnwcmeykqzgajlmuerhhsanpdtmrzibswswzjjbjqytgfewiuu";
        String s = super_reduced_string(target);
        System.out.println(s);
    }

    static boolean isDup(List<String> data, int index) {
        return data.get(index).equals(data.get(index + 1));
    }

    static String super_reduced_string(String s) {
        LinkedList<String> result = new LinkedList<>();
        result.addAll(Arrays.asList(s.split("")));
        int index = 0;
        while (true) {
            if (result.size() == 0) {
                break;
            }
            if (result.size() == index +1) {
                if (isEnd(result)) {
                    break;
                } else {
                    index = 0;
                }
            }
            System.out.println("size : " + result.size() + ", index : " + index);
            if (isDup(result, index)) {
                result.remove(index);
                result.remove(index);
            } else {
                index++;
            }
        }
        if (result.isEmpty()) {
            return "Empty String";
        }
        return String.join("", result);
    }

    static boolean isEnd(LinkedList<String> result) {
        String temp = "0";
        for(String s : result) {
            if (temp.equals(s)) {
                return false;
            }
            temp = s;
        }
        return true;
    }
}
