package eceris.etc.algospot.starter;

//https://algospot.com/judge/problem/read/DRAWRECT

import java.util.ArrayList;
import java.util.List;

public class DrawRect {

    public static void main(String[] args) {
        List<Point> rect = new ArrayList<>();
//        rect.add(new Point(5, 5));
//        rect.add(new Point(5, 7));
//        rect.add(new Point(7, 5));
        rect.add(new Point(30, 20));
        rect.add(new Point(10, 10));
        rect.add(new Point(10, 20));
        int x = 0;
        int y = 0;
        for (Point a : rect) {
            int xCount = 0;
            int yCount = 0;
            for (Point b : rect) {
                if (a.x == b.x) {
                    xCount++;
                }
                if (a.y == b.y) {
                    yCount++;
                }
            }
            if (xCount == 1) {
                x = a.x;
            }
            if (yCount == 1) {
                y = a.y;
            }
        }
        System.out.println(x + " " + y);
    }

    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
