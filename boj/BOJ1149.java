package boj;

public class BOJ1149 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[][] dp = new int[N][3];
        dp[0][0] = A[0][0];
        dp[0][1] = A[0][1];
        dp[0][2] = A[0][2];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + A[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + A[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + A[i][2];
        }

        System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N][3];
        for (int i = 0; i < N; i++) {
            int r = SC.nextInt();
            int g = SC.nextInt();
            int b = SC.nextInt();
            A[i][0] = r;
            A[i][1] = g;
            A[i][2] = b;
        }
    }
}
