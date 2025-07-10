package boj;

public class BOJ14606 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] DP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        DP[0] = 0;
        DP[1] = 0;
        DP[2] = 1;
        for (int i = 3; i <= 10; i++) {
            DP[i] = ((i / 2) * (i - i / 2)) + DP[i / 2] + DP[i - i / 2];
        }
        System.out.println(DP[N]);
    }

    private static void input() {
        N = SC.nextInt();
        DP = new int[11];
    }
}
