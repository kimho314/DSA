package boj;

public class BOJ10103 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] SCORES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            if (n1 < n2) {
                SCORES[0] -= n2;
            }
            if (n1 > n2) {
                SCORES[1] -= n1;
            }
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(SCORES[i]);
        }
    }

    private static void input() {
        N = SC.nextInt();
        SCORES = new int[2];
        SCORES[0] = 100;
        SCORES[1] = 100;
    }
}
