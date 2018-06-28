package kr.co.eceris.algospot.search;

//https://algospot.com/judge/problem/read/NQUEEN

public class NQueen {
    static int COUNT = 0;

    public static void main(String args[]) {

        int[] array = new int[4];
        function(0, array);
        System.out.println("solution count is " + COUNT + ".");
    }

    public static void function(int number, int[] array) {
        if (number == array.length) {
            COUNT++;
        } else {
            for (int i = 0; i < array.length; i++) {
                array[number] = i;
                if (isProperWay(number, array)) {
                    function(number + 1, array);
                }
            }
        }

    }

    public static boolean isProperWay(int number, int[] array) {
        for (int i = 0; i < number; i++) {
            if (array[i] == array[number]) return false;   // 같은 열인지
            if ((array[i] - array[number]) == (number - i)) return false;   // '\' 방향
            if ((array[number] - array[i]) == (number - i)) return false;   // '/' 방향
        }
        return true;
    }

}
