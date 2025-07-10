package boj;

public class BOJ15990 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long[][] dp = new long[100_001][3];
        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[1][2] = 0;
        dp[2][0] = 0;
        dp[2][1] = 1;
        dp[2][2] = 0;
        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;

        for (int i = 4; i <= 100_000; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 1_000_000_009;
            dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % 1_000_000_009;
            dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % 1_000_000_009;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            long res = (dp[NUMS[i]][0] + dp[NUMS[i]][1] + dp[NUMS[i]][2]) % 1_000_000_009;
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    private static void input() {
        T = SC.nextInt();
        NUMS = new int[T];
        for (int i = 0; i < T; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
