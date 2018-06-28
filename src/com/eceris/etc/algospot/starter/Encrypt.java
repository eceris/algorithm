package kr.co.eceris.algospot.starter;

//https://algospot.com/judge/problem/read/ENCRYPT

import java.util.ArrayList;
import java.util.List;

public class Encrypt {
    public static void main(String[] args) {
        String source="HelloWorld";
//        String source="A";

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();

        for(int i=0; i<source.length(); i++) {
            if (i%2 ==0) {
                evenNumbers.add(source.substring(i, i+1));
            } else {
                oddNumbers.add(source.substring(i, i+1));
            }
        }
        String even = String.join("", evenNumbers);
        String odd = String.join("", oddNumbers);
        System.out.println(even.concat(odd));

    }
}
