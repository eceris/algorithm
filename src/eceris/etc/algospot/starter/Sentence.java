package eceris.etc.algospot.starter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://algospot.com/judge/problem/read/SENTENCE
 */
public class Sentence {

    public static final Scanner SCN = new Scanner(System.in);


    public static void main(String [] args) {
        List<String> bookContents = new ArrayList<>();
        List<String> memoContents = new ArrayList<>();
        int book = Integer.parseInt(SCN.next());
        int memo = Integer.parseInt(SCN.next());
        SCN.nextLine();
        for (int i = 0; i < book ; i++) {
            bookContents.add(SCN.nextLine());
        }

        for (int i = 0; i < memo ; i++) {
            memoContents.add(SCN.nextLine());
        }

        int count = 0;
        for (String target : memoContents) {
            for (String content : bookContents) {
                if (content.startsWith(target)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
