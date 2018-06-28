package kr.co.eceris.algospot.implementation;

//https://algospot.com/judge/problem/read/URI

import java.util.ArrayList;
import java.util.List;

public class URIDecoding {

    public static void main(String[] args) {
        List<Characters> map = new ArrayList<>();
        map.add(new Characters(" ", "%20"));
        map.add(new Characters("!", "%21"));
        map.add(new Characters("$", "%24"));
        map.add(new Characters("%", "%25"));
        map.add(new Characters("(", "%28"));
        map.add(new Characters(")", "%29"));
        map.add(new Characters("*", "%2a"));

//        String source = "Happy%20Joy%20Joy%21";
        String source = "http://algospot.com/%2a";

        for(Characters c : map) {
            source = source.replaceAll(c.encoded, c.pure);
        }
        System.out.println(source);
    }

    public static class Characters {
        private String pure;
        private String encoded;

        public Characters(String pure, String encoded) {
            this.pure = pure;
            this.encoded = encoded;
        }
    }
}
