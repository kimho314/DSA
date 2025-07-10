package boj;

public class BOJ11727 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] DP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        DP = new int[1_000 + 1];
        DP[1] = 1;
        DP[2] = 3;
        for (int i = 3; i <= 1_000; i++) {
            DP[i] = (DP[i - 1] + (DP[i - 2] * 2)) % 10_007;
        }
        System.out.println(DP[N]);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
