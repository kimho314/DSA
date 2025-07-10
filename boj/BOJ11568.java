package boj;

import java.util.Arrays;

public class BOJ11568 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] CARDS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (CARDS[i] > CARDS[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = dp[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    private static void input() {
        N = SC.nextInt();
        CARDS = new int[N];
        for (int i = 0; i < N; i++) {
            CARDS[i] = SC.nextInt();
        }
    }
}
