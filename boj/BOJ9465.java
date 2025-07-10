package boj;

public class BOJ9465 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        while (T > 0) {
            T--;
            int n = SC.nextInt();
            int[][] arr = new int[n + 1][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[j][i] = SC.nextInt();
                }
            }
            solve(n, arr);
        }

        System.out.println(SB);
    }

    private static void solve(int n, int[][] arr) {
        int[][] dp = new int[n + 1][2];
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 2][0], dp[i - 2][1])) + arr[i][0];
            dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 2][0], dp[i - 2][1])) + arr[i][1];
        }

        int res = Math.max(dp[n][0], dp[n][1]);
        SB.append(res).append("\n");
    }


    private static void input() {
        T = SC.nextInt();
    }
}
