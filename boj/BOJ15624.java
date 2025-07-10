package boj;

public class BOJ15624 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] DP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        DP[0] = 0;
        DP[1] = 1;
        for (int i = 2; i <= 1_000_000; i++) {
            DP[i] = (DP[i - 1] % 1_000_000_007) + (DP[i - 2] % 1_000_000_007);
        }

        System.out.println(DP[N] % 1_000_000_007);
    }

    private static void input() {
        N = SC.nextInt();
        DP = new int[1_000_001];
    }
}
