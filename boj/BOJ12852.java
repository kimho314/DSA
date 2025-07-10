package boj;

public class BOJ12852 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] DP;
    static int[] TRACE;

    public static void main(String[] args) {
        init();
        solve();
    }

    private static void solve() {
        DP[0] = 0;
        DP[1] = 0;

        for (int i = 2; i <= N; i++) {
            DP[i] = DP[i - 1] + 1;
            TRACE[i] = i - 1;

            if (i % 2 == 0 && DP[i] > DP[i / 2] + 1) {
                DP[i] = DP[i / 2] + 1;
                TRACE[i] = i / 2;
            }
            if (i % 3 == 0 && DP[i] > DP[i / 3] + 1) {
                DP[i] = DP[i / 3] + 1;
                TRACE[i] = i / 3;
            }
        }

        System.out.println(DP[N]);
        int start = N;
        while (start > 0) {
            System.out.print(start + " ");
            start = TRACE[start];
        }
    }

    private static void init() {
        N = SC.nextInt();
        DP = new int[N + 1];
        TRACE = new int[N + 1];
    }

}
