package com.eceris.goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TEST2 {
    public static void main(String[] args) throws IOException {

//        List<String> data = Arrays.asList("2018-08-03|10001|A02", "2018-08-01|10004|A09", "2018-08-02|10001|A02", "2018-08-05|10001|A05",
//                "2018-08-09|10001|A07", "2018-08-10|10007|A09", "2018-08-08|10001|A05", "2018-08-08|10001|A02", "2018-08-04|10003|A01",
//                "2018-08-02|10003|A04", "2018-08-04|10003|A01", "2018-08-04|10003|A06", "2018-08-03|10006|A01", "2018-08-02|10006|A02",
//                "2018-08-03|10006|A04", "2018-08-10|10007|A09");
//        List<String> data = Arrays.asList("2018-08-03|10001|A02", "2018-08-01|10004|A09", "2018-08-02|10001|A02", "2018-08-05|10001|A05", "2018-08-09|10001|A07", "2018-08-10|10007|A09", "2018-08-08|10001|A05", "2018-08-08|10001|A02", "2018-08-04|10003|A01", "2018-08-02|10003|A04", "2018-08-04|10003|A01", "2018-08-04|10003|A06", "2018-08-10|10007|A09", "2018-08-08|10001|A05", "2018-08-08|10001|A05");
//        List<String> data = Arrays.asList("2018-08-01|10004|A09", "2018-08-10|10007|A09", "2018-08-01|10007|A04", "2018-08-10|10007|A09", "2018-08-01|10001|A05");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> data = new ArrayList<>();
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.equals(" ")) {
                break;
            }
            data.add(line);
        }
        calc(data);
    }

    public static List<Order> convert(List<String> data) {
        return data.stream().filter(s -> {
            String[] raw = s.split("\\|");
            if (raw[0].startsWith("2018-08-01") || raw[0].startsWith("2018-08-10")) {
                return false;
            }
            return true;
        }).map(s -> {
            try {
                String[] raw = s.split("\\|");
                return new Order(raw[0], raw[1], raw[2]);
            } catch (ArrayIndexOutOfBoundsException ex) {
                throw new IllegalArgumentException();
            }
        }).collect(Collectors.toList());
    }

    public static void calc(List<String> data) {
        List<Order> orders = convert(data);
        if (orders.isEmpty()) {
            System.out.println("NO RESULT");
            return;
        }
//        Comparator.comparingInt(o -> o.getValue().size() * -1)
        orders.stream()
                .collect(Collectors.groupingBy(Order::getProductNumber))
                .entrySet()
                .stream()
                .sorted(comparator())
                .limit(3)
                .forEach(stringListEntry -> {
                    String byRegion = stringListEntry.getValue()
                            .stream()
                            .collect(Collectors.groupingBy(Order::getRegionCode))
                            .entrySet()
                            .stream()
                            .sorted(comparator())
                            .limit(3)
                            .map(en -> {
                                String regionCode = en.getKey();
                                int countByRegion = en.getValue().size();
                                return regionCode + ":" + countByRegion;
                            }).collect(Collectors.joining(","));
                    String productCode = stringListEntry.getKey();
                    int countByProduct = stringListEntry.getValue().size();
                    System.out.println(productCode + ":" + countByProduct + "=>" + byRegion);
                });
    }

    /**
     * size로 비교(size가 같을 경우 key 비교)
     *
     * @return
     */
    private static Comparator<Map.Entry<String, List<Order>>> comparator() {
        return (o1, o2) -> {
            int o1Size = o1.getValue().size();
            int o2Size = o2.getValue().size();
            String o1Key = o1.getKey();
            String o2Key = o2.getKey();
            if (o1Size == o2Size) {
//                return o2Key.compareTo(o1Key);
                return o1Key.compareTo(o2Key);
            } else {
                return Integer.compare(o2Size, o1Size);
            }
        };
    }

    static class Order {
        private String date;
        private String productNumber;
        private String regionCode;

        public Order(String date, String productNumber, String regionCode) {
            this.date = date;
            this.productNumber = productNumber;
            this.regionCode = regionCode;
        }

        public String getDate() {
            return date;
        }

        public String getProductNumber() {
            return productNumber;
        }

        public String getRegionCode() {
            return regionCode;
        }
    }
}
