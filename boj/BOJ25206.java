package boj;

import java.util.HashMap;
import java.util.Map;

public class BOJ25206 {
    static FastReader SC = new FastReader();
    static Map<String, Double> SCORE = new HashMap<>();

    public static void main(String[] args) {
        init();

        double sum1 = 0.0;
        double sum2 = 0.0;
        for (int i = 0; i < 20; i++) {
            String name = SC.next();
            double score = SC.nextDouble();
            String grade = SC.next();

            if (grade.equals("P")) {
                continue;
            }
            sum1 += (SCORE.get(grade) * score);
            sum2 += score;
        }

        double res = sum1 / sum2;
        System.out.println(res);
    }

    private static void init() {
        SCORE.put("A+", 4.5);
        SCORE.put("A0", 4.0);
        SCORE.put("B+", 3.5);
        SCORE.put("B0", 3.0);
        SCORE.put("C+", 2.5);
        SCORE.put("C0", 2.0);
        SCORE.put("D+", 1.5);
        SCORE.put("D0", 1.0);
        SCORE.put("F", 0.0);
    }
}
