package com.eceris.goorm;

import java.util.Arrays;
import java.util.Stack;

public class DecimalToHex {

    static Stack<Integer> stk = new Stack<>();
    public static void main(String[] args) {
        calc(1000);
        while (!stk.isEmpty()) {
            String converted = convertAsHex(stk.pop());
            System.out.print(converted);
        }
    }
    static String convertAsHex(int source) {
        if (source > 9) {
            HexValue hexValue = HexValue.fromInt(source);
            return hexValue.name();
        } else {
            return String.valueOf(source);
        }
    }

    static void calc(int source) {
        int remained = source % 16;
        stk.push(remained);
        int val = source / 16;
        if (val > 16) {
            calc(val);
        } else {
            stk.push(val);
        }
    }

    public enum HexValue {

        a(10), b(11), c(12), d(13), e(14), f(15);
        private int value;
        HexValue(int value) {
            this.value = value;
        }
        static HexValue fromInt(int source) {
            return Arrays.stream(values()).filter(h -> source == h.value).findFirst().get();
        }
    }
}
