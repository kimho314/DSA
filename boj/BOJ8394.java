package boj;

public class BOJ8394 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static long[] DP = new long[10_000_001];

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 2;
        for (int i = 3; i <= 10_000_000; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2]) % 10;
        }

        System.out.println(DP[N]);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
