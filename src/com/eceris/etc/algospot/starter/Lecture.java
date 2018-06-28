package kr.co.eceris.algospot.starter;

//https://algospot.com/judge/problem/read/LECTURE

import java.util.ArrayList;
import java.util.List;

public class Lecture {
    public static void main(String[] args) throws Exception {
//        String source = "abbaaccb";
//        String source = "dddcccbbbaaa";
//        String source = "geegeegeegeebabybabybaby";
        String source = "oh";

        if (source.length() % 2 != 0) {
            throw new Exception("짝수 아님");
        }

        List<String> blockList = new ArrayList<>();
        for (int i = 0; i < source.length() - 1; i++) {
            if (i % 2 == 0) {
                blockList.add(source.substring(i, i + 2));
            }
        }
        System.out.println(blockList);
        sort(blockList);
        System.out.println(blockList);
    }

    public static void sort(List<String> blockList) {
        blockList.sort((o1, o2) -> {
            if (o1.charAt(0) > o2.charAt(0)) {
                return 1;
            } else if (o1.charAt(0) < o2.charAt(0)) {
                return -1;
            } else {
                if (o1.charAt(1) > o2.charAt(1)) {
                    return 1;
                } else if (o1.charAt(1) < o2.charAt(1)) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }
}
