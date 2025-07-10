package boj;

public class BOJ17175 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] dp = new int[51];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= 50; i++) {
            dp[i] = ((dp[i - 1] % 1_000_000_007) + (dp[i - 2] % 1_000_000_007) + 1) % 1_000_000_007;
        }

        System.out.println(dp[N]);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
