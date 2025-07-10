package boj;

public class BOJ2502 {
    static FastReader SC = new FastReader();
    static int D, K;
    static int[][] DP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        DP[0][0] = 0;
        DP[0][1] = 9;
        DP[1][0] = 1;
        DP[1][1] = 0;
        DP[2][0] = 0;
        DP[2][1] = 1;

        for (int i = 3; i <= 30; i++) {
            DP[i][0] = DP[i - 1][0] + DP[i - 2][0];
            DP[i][1] = DP[i - 1][1] + DP[i - 2][1];
        }

        int a = 0;
        int b = 0;
        for (int i = 1; i < K; i++) {
            double j = (double) (K - (i * DP[D][0])) / (double) DP[D][1];
            int num = (int) j;
            if (j == (double) num) {
                a = i;
                b = num;
                break;
            }
        }

        System.out.println(a);
        System.out.println(b);
    }

    private static void input() {
        D = SC.nextInt();
        K = SC.nextInt();
        DP = new int[30 + 1][2];
    }
}
