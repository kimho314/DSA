package boj;

public class BOJ2688 {
    private static FastReader SC = new FastReader();
    private static int T;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long[][] dp = new long[65][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int k = 2; k <= 64; k++) {
            for (int i = 0; i <= 9; i++) {
                for (int j = i; j <= 9; j++) {
                    dp[k][i] += dp[k - 1][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (T > 0) {
            T--;

            int n = SC.nextInt();

            long ans = 0;
            for (int i = 0; i <= 9; i++) {
                ans += dp[n][i];
            }

            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    private static void input() {
        T = SC.nextInt();
    }
}
