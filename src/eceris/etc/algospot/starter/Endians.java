package eceris.etc.algospot.starter;

//https://algospot.com/judge/problem/read/ENDIANS

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Endians {
    public static void main(String[] args) {
        String target = "2018915346";
        List<Long> bin = decToBin(target);
        List<List<Long>> binBlock = separateAs4Block(bin);
        String reversed = reverse(binBlock);
        String dec = binToDec(reversed);
        System.out.println(dec);

    }

    public static String binToDec(String source) {
        long value = 0;
        char[] chars = source.toCharArray();
        for (int i = 0; i < 32; i++) {
            char aChar = chars[i];
            String s = String.valueOf(aChar);
            int i1 = Integer.parseInt(s);
            long v = (long) (Math.pow(2, i) * i1);
            value += v;
        }
        return Long.toString(value);
    }

    public static String reverse(List<List<Long>> source) {
        Collections.reverse(source);
        StringBuilder dec = new StringBuilder();
        for (List<Long> block : source) {
            for (Long i : block) {
                dec.append(i.toString());
            }
        }
        System.out.println(dec.toString());
        return dec.toString();
    }

    public static List<List<Long>> separateAs4Block(List<Long> source) {
        List<List<Long>> binary32bit = new ArrayList<>();
        List<Long> target = null;
        int count = 0;
        for (Long i : source) {
            if (count == 0) {
                target = new ArrayList<>();
            }
            target.add(count, i);
            count++;
            if (count == 8) {
                binary32bit.add(target);
                count = 0;
            }
        }
        System.out.println(binary32bit);
        return binary32bit;
    }

    public static List<Long> decToBin(String source) {
        long temp = Long.parseLong(source);
        List<Long> binaryList = new ArrayList<>();
        StringBuilder forLogging = new StringBuilder();
        int count = 0;
        while (count < 32) {
            forLogging.append(temp % 2);
            binaryList.add(count++, temp % 2);
            temp = temp / 2;
        }
        System.out.println(forLogging.toString());
        return binaryList;
    }
}
