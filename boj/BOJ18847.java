package boj;

public class BOJ18847 {
    private static FastReader SC = new FastReader();
    private static int H, Y;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long[] dp = new long[Y + 1];
        dp[0] = H;

        for (int i = 1; i <= Y; i++) {
            dp[i] = (long) Math.floor(dp[i - 1] * 1.05);
            if (i >= 3) {
                dp[i] = Math.max((long) Math.floor(dp[i - 3] * 1.2), dp[i]);
            }
            if (i >= 5) {
                dp[i] = Math.max((long) Math.floor(dp[i - 5] * 1.35), dp[i]);
            }
        }

        System.out.println(dp[Y]);
    }


    private static void input() {
        H = SC.nextInt();
        Y = SC.nextInt();
    }
}
