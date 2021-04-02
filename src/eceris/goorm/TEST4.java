package eceris.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TEST4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tabStop = br.readLine();
        String content = br.readLine();
        String convert = convert(content, Integer.valueOf(tabStop));
        System.out.println(convert);

    }

    static String convert(String target, int tabStop) {
        String trim = target.trim();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < tabStop; i++) {
            sb.append(" ");
        }
        return sb.append(trim).toString();
    }
}
