package boj;

import java.util.HashMap;

public class BOJ1076 {
    private static FastReader SC = new FastReader();
    private static String[] COLORS;
    private static HashMap<String, String> MAP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        String[] split1 = MAP.get(COLORS[0]).split("-");
        String[] split2 = MAP.get(COLORS[1]).split("-");
        long res = Integer.parseInt(split1[0] + split2[0]);

        String[] split3 = MAP.get(COLORS[2]).split("-");
        res *= Integer.parseInt(split3[1]);

        System.out.println(res);
    }

    private static void input() {
        COLORS = new String[3];
        for (int i = 0; i < 3; i++) {
            COLORS[i] = SC.next();
        }

        MAP = new HashMap<>();
        MAP.put("black", 0 + "-" + 1);
        MAP.put("brown", 1 + "-" + 10);
        MAP.put("red", 2 + "-" + 100);
        MAP.put("orange", 3 + "-" + 1_000);
        MAP.put("yellow", 4 + "-" + 10_000);
        MAP.put("green", 5 + "-" + 100_000);
        MAP.put("blue", 6 + "-" + 1_000_000);
        MAP.put("violet", 7 + "-" + 10_000_000);
        MAP.put("grey", 8 + "-" + 100_000_000);
        MAP.put("white", 9 + "-" + 1_000_000_000);
    }
}
