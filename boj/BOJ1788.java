package boj;

public class BOJ1788 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] dp = new int[1_000_001];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= 1_000_000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_000;
        }

        int sign = -2;
        if (N == 0) {
            sign = 0;
        }
        else if (N > 0) {
            sign = 1;
        }
        else {
            if (Math.abs(N) % 2 == 0) {
                sign = -1;
            }
            else {
                sign = 1;
            }
        }

        int res = dp[Math.abs(N)];

        System.out.println(sign);
        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
