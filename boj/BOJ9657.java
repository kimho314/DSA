package boj;

public class BOJ9657 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] DP;

    public static void main(String[] args) {
        init();
        solve();
    }

    private static void solve() {
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 0;
        DP[3] = 1;
        DP[4] = 1;
        for (int i = 5; i <= N; i++) {
            if (DP[i - 1] == 1 && DP[i - 3] == 1 && DP[i - 4] == 1) {
                DP[i] = 0;
            }
            else {
                DP[i] = 1;
            }
        }

        if (DP[N] == 1) {
            System.out.println("SK");
        }
        else {
            System.out.println("CY");
        }
    }

    private static void init() {
        N = SC.nextInt();
        DP = new int[1001];
    }
}
