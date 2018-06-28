package kr.co.eceris;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    public static void main(String args[]) {
        String str = "progxrammerrxproxgrammer"; //2
//        String str = "xprogxrmaxemrppprmmograeiruu"; //2
//        String str = "programmerprogrammer";//0
        int i = programmerStrings(str);
    }

    static int programmerStrings(String s) {
        /*
         * Write your code here.
         */
        String programmer = "programmer";
        int leftIndex = getIndex(s, programmer)+1;
        int index = getIndex(new StringBuilder(s).reverse().toString(), new StringBuilder(programmer).reverse().toString());



        int rightIndex = s.length() -1 - index;
        System.out.println(rightIndex - leftIndex);

        return rightIndex - leftIndex;
    }

    static int getIndex(String s, String programmer) {

        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            String candidate = s.substring(j, j + 1);
            for (int i = 0; i < programmer.length(); i++) {
                String key = programmer.substring(i, i + 1);
                if (candidate.equals(key)) {
                    count++;
                    break;
                }
            }
            if (count == programmer.length()) {
                return j;
            }
        }
        return -1;
    }
}
