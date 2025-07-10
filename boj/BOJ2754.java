package boj;

import java.util.HashMap;
import java.util.Map;

public class BOJ2754 {
    static FastReader SC = new FastReader();
    static Map<String, Double> SCORE_MAP = new HashMap<>();
    static String INPUT;

    public static void main(String[] args) {
        init();
        solve();
    }

    private static void solve() {
        double score = SCORE_MAP.get(INPUT);
        System.out.println(score);
    }

    private static void init() {
        SCORE_MAP.put("A+", 4.3);
        SCORE_MAP.put("A0", 4.0);
        SCORE_MAP.put("A-", 3.7);
        SCORE_MAP.put("B+", 3.3);
        SCORE_MAP.put("B0", 3.0);
        SCORE_MAP.put("B-", 2.7);
        SCORE_MAP.put("C+", 2.3);
        SCORE_MAP.put("C0", 2.0);
        SCORE_MAP.put("C-", 1.7);
        SCORE_MAP.put("D+", 1.3);
        SCORE_MAP.put("D0", 1.0);
        SCORE_MAP.put("D-", 0.7);
        SCORE_MAP.put("F", 0.0);

        INPUT = SC.nextLine();
    }
}
