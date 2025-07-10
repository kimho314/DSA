package boj;

import java.util.Arrays;

public class BOJ9076 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        while (T > 0) {
            T--;
            solve();
        }

        System.out.println(SB);
    }

    private static void solve() {
        int[] scores = new int[5];
        for (int i = 0; i < 5; i++) {
            scores[i] = SC.nextInt();
        }

        Arrays.sort(scores);

        boolean isKin = scores[3] - scores[1] >= 4;
        if (isKin) {
            SB.append("KIN").append("\n");
        } else {
            int sum = 0;
            for (int i = 1; i <= 3; i++) {
                sum += scores[i];
            }
            SB.append(sum).append("\n");
        }
    }

    private static void input() {
        T = SC.nextInt();
    }
}
