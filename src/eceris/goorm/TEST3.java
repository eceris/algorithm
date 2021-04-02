package eceris.goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TEST3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> data = new ArrayList<>();
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.equals("END")) {
                break;
            }
            data.add(line);
        }
        data.sort((o1, o2) -> {
            Date convert1 = convert(o1);
            Date convert2 = convert(o2);
            return convert1.compareTo(convert2);
        });
        data.stream().forEach(s -> System.out.println(s));
    }

    public static Date convert(String target) {
        Pattern p1 = Pattern.compile("(\\d+/\\d+/\\d+)");   // the pattern to search for
        Pattern p2 = Pattern.compile("(\\d+년\\d+월\\d+일)");   // the pattern to search for
        Pattern p3 = Pattern.compile("(\\d+-\\d+-\\d+)");   // the pattern to search for
        Matcher m1 = p1.matcher(target);
        Matcher m2 = p2.matcher(target);
        Matcher m3 = p3.matcher(target);
        try {
            if (m1.find()) {
                String s = m1.group(1);
                SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
                return dt.parse(s);
            } else if (m2.find()) {
                String s = m2.group(1);
                SimpleDateFormat dt = new SimpleDateFormat("yy년MM월dd일");
                return dt.parse(s);
            } else if (m3.find()) {
                String s = m3.group(1);
                SimpleDateFormat dt = new SimpleDateFormat("yy-MM-dd");
                return dt.parse(s);
            }
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return new Date();
    }
}
