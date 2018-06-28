package kr.co.eceris;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution2 {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
        filename = scan.nextLine();

        int count = 0;
        long sum =0;
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while(true) {
            String line = br.readLine();
            if (line==null) break;
            String[] split = line.split(" ");
            int value = Integer.parseInt(split[9]);
            if (value > 5000) {
                count++;
                sum += value;
            }
        }
        br.close();


        PrintWriter pw = new PrintWriter("bytes_" + filename);
        System.out.println(count);
        System.out.println(sum);
        pw.println(count);
        pw.println(sum);
        pw.close();
    }
}
