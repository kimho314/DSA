package boj;

public class BOJ11051 {
    private static FastReader SC = new FastReader();
    private static int N, K;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[][] dp = new int[1001][1001];

        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = (int) ((long) dp[i - 1][j] + (long) dp[i - 1][j - 1]) % 10_007;
                }
            }
        }

//        for (int i = 0; i <= 1000; i++) {
//            for (int j = 0; j <= i; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[N][K]);
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
    }
}
