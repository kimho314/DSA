package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ11656 {
    static FastReader SC = new FastReader();
    static String INPUT;

    public static void main(String[] args) {
        init();
        solve();
    }

    private static void solve() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < INPUT.length(); i++) {
            list.add(INPUT.substring(i));
        }

        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void init() {
        INPUT = SC.next();
    }
}
