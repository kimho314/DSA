package boj;

public class BOJ1463 {
    static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] dp = new int[1_000_000 + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= 1_000_000; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }


        System.out.println(dp[N]);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
