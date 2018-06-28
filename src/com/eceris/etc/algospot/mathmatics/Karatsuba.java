package kr.co.eceris.algospot.mathmatics;

import java.util.Scanner;

public class Karatsuba {
//    private static final int[] X = {1, 2, 3, 4};
//    private static final int[] Y = {5, 6, 7, 8};

    public static void main(String[] args) {


//        z2 = 12 × 56 = 672
//        z2 = x1y1

//        z0 = 34 × 78 = 2652
//        z0 = x0y0

//        z1 = (12 + 34)(56 + 78) − z2 − z0 = 46 × 134 − 672 − 2652 = 2840
//        z1 = (x1y1 + x1y0 + x0y1 + x0y0) - x1y1 - x0y0 = x1y0 + x0y1

//        결과 = z2 × 102×2 + z1 × 102 + z0 = 672 × 10000 + 2840 × 100 + 2652 = 7006652

        String x;
        String y;
        try (Scanner scanner = new Scanner(System.in)) {
            x = scanner.nextLine();
            y = scanner.nextLine();
        }
        int[] X = toIntArray(x);
        int[] Y = toIntArray(y);

        int x1 = getPrimaryNumber(X);
        int x2 = getSecondaryNumber(X);
        int y1 = getPrimaryNumber(Y);
        int y2 = getSecondaryNumber(Y);

        int z2 = x1 * y1;
        int z0 = x2 * y2;
        int z1 = (x1 + x2) * (y1 + y2) - z2 - z0;

        int i = z2 * 10000 + z1 * 100 + z0;
        System.out.println(i);

    }

    public static int[] toIntArray(String str) {
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        return result;
    }

    public static int getPrimaryNumber(int[] arr) {
        StringBuilder value = new StringBuilder();
        int count = 0;
        while (arr.length / 2 > count) {
            value.append(arr[count]);
            count++;
        }
        return Integer.parseInt(value.toString());
    }

    public static int getSecondaryNumber(int[] arr) {
        StringBuilder value = new StringBuilder();
        int count = arr.length / 2;
        while (arr.length > count) {
            value.append(arr[count]);
            count++;
        }
        return Integer.parseInt(value.toString());
    }
}
