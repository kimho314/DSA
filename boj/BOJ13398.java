package boj;

public class BOJ13398 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[][] dp = new int[N + 1][2];
        dp[1][0] = A[1];
        dp[1][1] = A[1];
        int max = A[1];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.max(0, dp[i - 1][0]) + A[i];
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 1][1]) + A[i];
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(max);
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
