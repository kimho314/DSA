package boj;

public class BOJ14656 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] ARR;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (i != ARR[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void input() {
        N = SC.nextInt();
        ARR = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            ARR[i] = SC.nextInt();
        }
    }
}
