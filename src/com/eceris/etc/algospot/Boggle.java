package kr.co.eceris.algospot;

//https://algospot.com/judge/problem/read/BOGGLE

//1
//URLPM
//XPRET
//GIAET
//XTNZY
//XOQRS
//6
//PRETTY YES
//GIRL YES
//REPEAT YES
//KARA NO
//PANDORA NO
//GIAZAPX YES
public class Boggle {
    public static final String[][] ARRAY = {{"U", "R", "L", "P", "M"}, {"X", "P", "R", "E", "T"}, {"G", "I", "A", "E", "T"},
            {"X", "T", "N", "Z", "Y"}, {"X", "O", "Q", "R", "S"}};

    public static final String word = "GIAZAPX";
    public static final int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
    public static final int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};
    public static void main(String args[]) {
        for (int i=0 ; i < 5 ; i++) {
            for (int j=0 ; j < 5 ; j++) {
                hasWord(i, j, word);
            }
        }
        hasWord(0, 0, word);
    }

    public static boolean hasWord(int y, int x, String word) {
        //기저사례1 : 시작위치가 범위 밖이면 실패
       if (!isValidPosition(y, x)) {
           return false;
       }
        //기저사례2 : 첫 글자가 일치하지 않으면 실패
       if (!ARRAY[y][x].equals(String.valueOf(word.charAt(0)))) {
           return false;
       }
        //기저사례3 : 단어길이가 1이면 성공
       if (word.length() == 1) {
           System.out.println(ARRAY[y][x]);
           return true;
       }

       //인접한 8칸을 조사
       for (int direction=0 ; direction < 8 ; ++direction) {
           int nextY = y + dy[direction];
           int nextX = x + dx[direction];
           if (hasWord(nextY, nextX, word.substring(1))) {
               return true;
           }
       }
       return false;
    }

    public static boolean isValidPosition(int y, int x) {
        if (x < 0 || x >= 5) {
            return false;
        }
        if (y < 0 || y >= 5) {
            return false;
        }
        return true;
    }


}
