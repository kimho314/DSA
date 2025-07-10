package boj;

public class BOJ9658 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] DP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        DP[1] = 1;
        DP[2] = 0;
        DP[3] = 1;
        for (int i = 4; i <= 1000; i++) {
            if (DP[i - 1] + DP[i - 3] + DP[i - 4] > 0) {
                DP[i] = 0;
            }
            else {
                DP[i] = 1;
            }
        }

        if (DP[N] == 0) {
            System.out.println("SK");
        }
        else {
            System.out.println("CY");
        }
    }

    private static void input() {
        N = SC.nextInt();
        DP = new int[1000 + 1];
    }
}
