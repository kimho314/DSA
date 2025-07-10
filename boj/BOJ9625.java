package boj;

public class BOJ9625 {
    static FastReader SC = new FastReader();
    static int K;

    public static void main(String[] args) {
        K = SC.nextInt();

        int[][] dp = new int[46][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i <= 45; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }

        System.out.println(dp[K][0] + " " + dp[K][1]);
    }
}
