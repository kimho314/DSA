package boj;

import java.util.*;

public class BOJ12904 {
    private static FastReader SC = new FastReader();
    private static String S, T;
    private static int RES = 0;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        S = SC.next();
        T = SC.next();
    }

    private static void solve() {
        recFunc(T);

        System.out.println(RES);
    }

    private static void recFunc(String s) {
        if (s.length() < S.length()) {
            return;
        } else if (s.length() == S.length() && !s.equals(S)) {
            return;
        } else if (s.length() == S.length() && s.equals(S)) {
            RES = 1;
            return;
        } else {
            if (s.charAt(s.length() - 1) == 'A') {
                String tmp = s.substring(0, s.length() - 1);
                recFunc(tmp);
            }
            if (s.charAt(s.length() - 1) == 'B') {
                String tmp = s.substring(0, s.length() - 1);
                StringBuilder sb = new StringBuilder();
                sb.append(tmp).reverse();
                tmp = sb.toString();
                recFunc(tmp);
            }
        }
    }
}
