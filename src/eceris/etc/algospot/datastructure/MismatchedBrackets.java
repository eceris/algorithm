package eceris.etc.algospot.datastructure;

//https://algospot.com/judge/problem/read/BRACKETS2

import java.util.Stack;

public class MismatchedBrackets {
    public static void main(String[] args) {
//        String source = "()()";
//        String source = "({[}])";
        String source = "({}[(){}])";
        Stack<String> store = new Stack<>();
        for (int i = 0; i < source.length(); i++) {
            if (store.empty()) {
                store.push(source.substring(i, i+1));
            } else {
                if (isCorrespondingPair(source.substring(i, i+1), store.peek())) {
                    store.pop();
                } else {
                    store.push(source.substring(i, i+1));
                }
            }
        }
        if (store.empty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static boolean isCorrespondingPair(String source, String target) {
        if("(".equals(source) && ")".equals(target) || ")".equals(source) && "(".equals(target)) {
            return true;
        }
        if("{".equals(source) && "}".equals(target) || "}".equals(source) && "{".equals(target)) {
            return true;
        }
        if("[".equals(source) && "]".equals(target) || "]".equals(source) && "[".equals(target)) {
            return true;
        }
        return false;
    }
}
