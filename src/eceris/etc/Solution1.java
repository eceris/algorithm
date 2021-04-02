package eceris.etc;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1 {

    /*
     * Complete the decode function below.
     */
    static String decode(String encoded) {
        StringBuilder decoded = new StringBuilder();

        if (encoded.isEmpty()) {
            return "";
        }
        String reversed = new StringBuilder(encoded).reverse().toString();
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < reversed.length(); i++) {
            String substring = reversed.substring(i, i + 1);
            queue.add(substring);
        }

        String temp = "";
        while (!queue.isEmpty()) {
            String poll = temp + queue.poll();
            if (isSpace(poll) || isLowercase(poll) || isUppercase(poll)) {
                int i = Integer.parseInt(poll);
                decoded.append(Character.toString((char) i));
                temp = "";
            } else {
                temp = poll;
            }
        }
        System.out.println(decoded.toString());

        return decoded.toString();
    }

    private static boolean isSpace(String value) {
        int target = Integer.parseInt(value);

        if (target == 32) {
            return true;
        }
        return false;
    }

    private static boolean isUppercase(String value) {
        int target = Integer.parseInt(value);

        if (target > 64 && target < 91) {
            return true;
        }
        return false;
    }

    private static boolean isLowercase(String value) {
        int target = Integer.parseInt(value);

        if (target > 96 && target < 123) {
            return true;
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String encoded = scanner.nextLine();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
        String res = decode("");
//
//        bufferedWriter.write(res);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}