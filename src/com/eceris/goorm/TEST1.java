package com.eceris.goorm;

import java.util.*;

public class TEST1 {
    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        String target = br.readLine();

        int target = 8;
        String input = "1 2 3 4 5";
        int[] arr = Arrays.stream(input.split(" ")).mapToInt(s -> Integer.valueOf(s)).toArray();
        calc(arr, Integer.valueOf(target));
    }

    public static void calc(int[] arr, int target) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
//                        System.out.println(arr[i] + ", " + arr[j] + ", " + arr[k]);
                        int r[] = {arr[i], arr[j], arr[k]};
                        Arrays.sort(r);
                        List<String> re = new ArrayList<>();
                        re.add(String.valueOf(r[0]));
                        re.add(String.valueOf(r[1]));
                        re.add(String.valueOf(r[2]));
                        String join = String.join(" ", re);
//                        System.out.println(join);
                        set.add(join);
                    }
                }
            }
        }

        if (set.isEmpty()) {
            System.out.println("NO");
        } else {
            List<String> strings = new ArrayList<>(set);
            Collections.sort(strings);
            strings.stream().forEach(s -> {
                System.out.println(s);
            });
        }
    }
}
