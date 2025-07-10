package boj;

public class BOJ15650 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] SELECTED;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        SELECTED = new int[M];
    }

    private static void solve() {
        recFunc(0, 0);
        System.out.println(SB);
    }

    private static void recFunc(int prev, int k) {
        if (k == M) {
            for (int elem : SELECTED) {
                SB.append(elem).append(" ");
            }
            SB.append("\n");
        } else {
            for (int i = prev + 1; i <= N; i++) {
                SELECTED[k] = i;
                recFunc(i, k + 1);
                SELECTED[k] = 0;
            }
        }
    }
}
