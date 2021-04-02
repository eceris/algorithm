package eceris.etc.kakao;

public class SecretMap {

    public static void main(String[] args) {
//        int number = 5;
//        int arr1[] = {9, 20, 28, 18, 11};
//        int arr2[] = {30, 1, 21, 17, 28};
        int number = 6;
        int arr1[] = {46, 33, 33 ,22, 31, 50};
        int arr2[] = {27 ,56, 19, 14, 14, 10};

        for (int i = 0; i < arr1.length; i++) {
            String row1 = decToBin(arr1[i], number);
            String row2 = decToBin(arr2[i], number);

            String result = OR(row1, row2);
            System.out.println(result);
        }
    }

    private static String decToBin(int dec, int number) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i< number; i++ ) {
            if (dec == 0) {
                builder.append(0);
                continue;
            }
            int value = dec % 2;
            dec = dec / 2;
            builder.append(value);
        }

        String bin = builder.reverse().toString();
        return bin;
    }
    private static String OR(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        while (true) {
            boolean valueA;
            boolean valueB;
            if (count == a.length()) {
                valueA = a.substring(count).equals("0") ? false : true;
                valueB = b.substring(count).equals("0") ? false : true;
                break;
            } else {
                valueA = a.substring(count, count + 1).equals("0") ? false : true;
                valueB = b.substring(count, count + 1).equals("0") ? false : true;
            }

            if (Boolean.logicalOr(valueA, valueB)) {
                builder.append("#");
            } else {
                builder.append(" ");
            }
            count++;
        }
        return builder.toString();
    }


}
