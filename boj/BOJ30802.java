package boj;

public class BOJ30802 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int T, P;
    private static int[] SHIRTS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cntT = 0;
        for (int i = 0; i < 6; i++) {
            cntT += SHIRTS[i] / T;
            if (SHIRTS[i] % T > 0) {
                cntT++;
            }
        }

        int cntP1 = N / P;
        int cntP2 = N % P;

        System.out.println(cntT);
        System.out.println(cntP1 + " " + cntP2);
    }

    private static void input() {
        N = SC.nextInt();
        SHIRTS = new int[6];
        for (int i = 0; i < 6; i++) {
            SHIRTS[i] = SC.nextInt();
        }
        T = SC.nextInt();
        P = SC.nextInt();
    }
}
