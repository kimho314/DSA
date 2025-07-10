package boj;

public class BOJ17216 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = A[i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] < A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
//            System.out.println(i + " " + dp[i]);
            if (res < dp[i]) {
                res = Math.max(res, dp[i]);
            }
        }
        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
