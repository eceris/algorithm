package com.KwonGusung.etc;

public class Gcd {

	/**
     * 최대공약수
     * 참조 : https://ko.wikipedia.org/wiki/%EC%B5%9C%EB%8C%80%EA%B3%B5%EC%95%BD%EC%88%98
     * @param n
     * @param m
     * @return
     */
    static int gcd(int n, int m) {
    	int quotient = m % n;
    	if(quotient == 0) {
    		return n;
    	} else {
    		return gcd(quotient, n);
    	}
    }
    
    static int gcd(int... values) {
    	int gcd = values[0];
    	for(int i = 1; i < values.length; i++) {
    		gcd = gcd(gcd, values[i]);
    	}
    	return gcd;
    }
    
    public static void main(String[] args) {
    	int[] values = new int[]{192, 72, 36};
		System.out.println(gcd(values));
	}
}
