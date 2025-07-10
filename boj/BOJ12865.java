package boj;

public class BOJ12865 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static int[][] ITEMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[][] dp = new int[N + 1][K + 1];

        for (int k = 1; k <= K; k++) {
            for (int i = 1; i <= N; i++) {
                dp[i][k] = dp[i - 1][k];
                if (k - ITEMS[i][0] >= 0) {
                    dp[i][k] = Math.max(dp[i][k], dp[i - 1][k - ITEMS[i][0]] + ITEMS[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }


    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        ITEMS = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            ITEMS[i][0] = SC.nextInt();
            ITEMS[i][1] = SC.nextInt();
        }
    }
}
