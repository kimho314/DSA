package boj;

import java.util.Arrays;

public class BOJ5800 {
    private static FastReader SC = new FastReader();
    private static int K;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            int n = SC.nextInt();
            int[] scores = new int[n];
            for (int j = 0; j < n; j++) {
                scores[j] = SC.nextInt();
            }

            Arrays.sort(scores);
            int max = scores[n - 1];
            int min = scores[0];
            int maxGap = 0;
            for (int j = n - 1; j > 0; j--) {
                maxGap = Math.max(maxGap, scores[j] - scores[j - 1]);
            }
            sb.append("Class")
                    .append(" ")
                    .append(i + 1)
                    .append("\n")
                    .append("Max ")
                    .append(max)
                    .append(", ")
                    .append("Min ")
                    .append(min)
                    .append(", ")
                    .append("Largest ")
                    .append("gap ")
                    .append(maxGap)
                    .append("\n");

        }
        System.out.println(sb);
    }

    private static void input() {
        K = SC.nextInt();
    }
}