package boj;

public class BOJ11052 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] P;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = P[i];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + P[i - j]);
            }
        }

        System.out.println(dp[N]);
    }

    private static void input() {
        N = SC.nextInt();
        P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            P[i] = SC.nextInt();
        }
    }
}
