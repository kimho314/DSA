package boj;

public class BOJ15988 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long[] dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 1_000_000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[NUMS[i]] % 1_000_000_009).append("\n");
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
