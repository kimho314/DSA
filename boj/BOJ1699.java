package boj;

public class BOJ1699 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] dp = new int[100_000 + 1];
        for (int i = 1; i <= 100_000; i++) {
            dp[i] = i;
        }

        for (int i = 2; i <= 100_000; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }

        System.out.println(dp[N]);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
