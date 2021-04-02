package eceris.algorithm.tip;

public class LCM_GCD {

    /**
     * 최대공약수
     * 참조 : https://ko.wikipedia.org/wiki/%EC%B5%9C%EB%8C%80%EA%B3%B5%EC%95%BD%EC%88%98
     *
     * @param n
     * @param m
     * @return
     */
    static int gcd(int n, int m) {
        int remained = m % n;
        if (remained == 0) {
            return n;
        } else {
            return gcd(remained, n);
        }
    }

    static int gcd(int... values) {
        int gcd = values[0];
        for (int i = 1; i < values.length; i++) {
            gcd = gcd(gcd, values[i]);
        }
        return gcd;
    }

    /**
     * 최소공배수
     * 참조 : https://ko.wikipedia.org/wiki/%EC%B5%9C%EC%86%8C%EA%B3%B5%EB%B0%B0%EC%88%98
     *
     * @param n
     * @param m
     * @return
     */
    static int lcm(int n, int m) {
        return (n * m) / gcd(n, m);
    }

    static int lcm(int... values) {
        int lcm = 1;
        for (int value : values) {
            lcm = lcm(lcm, value);
        }
        return lcm;
    }

    public static void main(String[] args) {
        int[] values = {48, 16, 8};
        System.out.println("최대공약수 : " + gcd(values));
        System.out.println("최소공배수 : " + lcm(values));
    }
}
