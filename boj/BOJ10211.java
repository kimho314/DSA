package boj;

public class BOJ10211 {
    static FastReader SC = new FastReader();
    static int T;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        while (T > 0) {
            T--;

            int n = SC.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = SC.nextInt();
            }

            int[] dp = new int[n];
            dp[0] = a[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(a[i], dp[i - 1] + a[i]);
            }

            int max = dp[0];
            for (int i = 1; i < n; i++) {
                max = Math.max(max, dp[i]);
            }
            SB.append(max).append('\n');
        }

        System.out.println(SB.toString());
    }

    private static void input() {
        T = SC.nextInt();
    }
}
