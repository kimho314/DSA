package boj;

public class BOJ1453 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        boolean[] used = new boolean[101];

        int res = 0;
        for (int i = 0; i < N; i++) {
            int n = SC.nextInt();
            if (!used[n]) {
                used[n] = true;
            } else {
                res++;
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
