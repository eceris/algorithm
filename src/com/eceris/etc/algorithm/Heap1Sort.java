package kr.co.eceris.algorithm;

/**
 * Created by PSH on 2017-07-17.
 */
public class Heap1Sort {
    private static int[] HEAP;
    private static int INDEX = 0;
    public static void main(String[] args) {

//        int[] numbers = {6,5,3,1,8,7,2,4};
        int[] numbers = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
//        1. 주어진 데이터(배열)로 힙을 만든다.
//        2. 힙에서 최대값(루트)을 가장 마지막 값과 바꾼다.
//        3. 힙의 크기를 1 줄어든 것으로 간주한다.
//        4. 루트노드에 대해서 HEAPIFY()한다.
//        5. 2~4번을 반복한다.
//        heapify();
        System.out.println("END");
        int LENGTH = numbers.length;
        HEAP = new int[LENGTH];
        for (int i =0 ; i <LENGTH; i++ ) {
            heap(numbers[i]);
            print(HEAP);
        }
    }
//    16 14 10 8 2 3 9 1 4 7

    public static void heap(int item) {
        int count =  ++INDEX;
        while((count != 1) &&(item > HEAP[count/2])) {
            HEAP[count] = HEAP[count/2];
            count = count/2;
        }


            HEAP[count] = item;

    }
    //      12
    //     9   8
    //   3  6  2  1
    //  4

    //       9
    //    12   1
    //   3  6 2 8
    //  4

    public static void heapify() {
        //배열을 HEAP 자료형으로 만든다.
        //              1d  2d 2d  3d 3d 3d 3d 4d
//        int[] numbers = {9, 12, 1, 3, 6, 2, 8, 4};
        // 1depth의 자식노드 numbers[2i], numbers[2i+1]
        int[] numbers = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        int i = 1;
        while (true) {
            int target = numbers[i-1];
            int left = numbers[2*i-1];

            if (2*i == numbers.length) {
                if (left > target){
                    numbers[i-1] = left;
                    numbers[2*i-1] = target;
                }
                print(numbers);
                break;
            }
            int right =numbers[2*i];

            if (left > right) {
                if(left > target) {
                    numbers[i-1] = left;
                    numbers[2*i-1] = target;
                }
            }else if (right > left) {
                if (right > target) {
                    numbers[i-1] = right;
                    numbers[2*i] = target;
                }
            }
            i++;

            print(numbers);
        }

    }

    public static void print(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("");
    }
    public static void h(int [] numbers, int i) {
        boolean done =false;
        int dad, temp;
        dad = (i - 1) /2;
        while((dad > 0 || dad == 0) && !done) {
            if (numbers[i] > numbers[dad]) {
                temp = numbers[i];
                numbers[i] = numbers[dad];
                numbers[dad] = temp;
                i = dad;
                dad = dad /2;
            }else {done = true;}
            print(numbers);
        }
    }
}
