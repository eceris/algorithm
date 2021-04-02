package eceris.etc.kakao;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class DartGame {

    public static void main(String args[]) {
        String data = "1S2D*3T";

        StringTokenizer tokenizer = new StringTokenizer(data, "SDT");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println(token);
        }
    }

    public Shot generateShot(String data, String area) {
        int i = data.indexOf(area);
        Shot shot = new Shot();
        shot.setPoint(data.substring(i-1, i));

        return null;
    }


    public List<Shot> generateShots(String data) {
//        string
//        큐를 활용
        List<String> result = Arrays.asList(data.split(""));
        for (int i =0; i< result.size(); i++) {
            if (i+1 < result.size()) {
                //끝
                continue;
            }




        }
        return null;
    }

    private boolean isArea(String target) {
        List<String> areas = Arrays.asList("S", "D", "T");
        return areas.contains(target);
    }

    private boolean isOption(String target) {
        List<String> options = Arrays.asList("*", "#");
        return options.contains(target);
    }

    private class Shot{
        private String point;
        private String area;
        private String option;

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getOption() {
            return option;
        }

        public void setOption(String option) {
            this.option = option;
        }
    }
}
