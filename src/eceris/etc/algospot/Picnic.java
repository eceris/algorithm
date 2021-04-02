package eceris.etc.algospot;

import java.util.ArrayList;

public class Picnic {
    public static void main(String args[]) {
        int count = 0;
        int mem = 6;
        int couple = 10;
        int arr[] = {0, 1, 0, 2, 1, 2, 1, 3, 1, 4, 2, 3, 2, 4, 3, 4, 3, 5, 4, 5 };
//        int arr[] = {0, 1, 1, 2, 2, 3, 3, 0, 0, 2, 1, 3 };

        ArrayList<ArrayList<Integer>> whole = new ArrayList<>();

        for(int i=0; i< couple; i++) {
            int firstIndex = i * 2;
            int secondIndex = i * 2 + 1;
            ArrayList<Integer> c = new ArrayList<>();
            c.add(arr[firstIndex]);
            c.add(arr[secondIndex]);
            whole.add(c);
        }



        for(int i =0; i < whole.size() - 1 ; i++) {
            for(int j = i +1; j < whole.size() ; j++) {
                if (isSame(whole.get(i), whole.get(j))) {
                    //pass
                    continue;
                }
                if (isContain(whole.get(i), whole.get(j))) {
                    //pass
                    continue;
                }
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isSame(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
            if (arr1.get(0).compareTo(arr2.get(0)) == 0 && arr1.get(1).compareTo(arr2.get(1)) == 0) {
                return true;
            }
        //두개의 arr이 같은 멤버를 갖고 있는지 확인
        //각 arr은 원소 두개를 갖는다.
        return false;
    }

    public static boolean isContain(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        //현재 whole이 해당 원소를 갖고 잇는지 판단.
        //갖고 있을 경우 패스~
        //갖고 있지 않을 경우 count 한다.
        for(Integer v : arr1) {
            if (v.compareTo(arr2.get(0)) == 0 || v.compareTo(arr2.get(1)) == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotSorted() {
        return false;
    }

    public static void removeDuplicated() {
        //모든 아이템을 한바퀴씩 돌면서 만들고 나서
        //sorting 된 내용만 count 하여 반환

    }
}
