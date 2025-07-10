package boj;

public class BOJ16395 {
    static FastReader SC = new FastReader();
    static int N, K;

    public static void main(String[] args) {
        N = SC.nextInt();
        K = SC.nextInt();

        long[][] dp = new long[31][31];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        for (int i = 3; i <= 30; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
