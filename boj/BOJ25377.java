package boj;

public class BOJ25377 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] TIMES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            if (TIMES[i][0] > TIMES[i][1]) {
                continue;
            }

            res = Math.min(res, TIMES[i][1]);
        }

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(res);
        }
    }

    private static void input() {
        N = SC.nextInt();
        TIMES = new int[N][3];
        for (int i = 0; i < N; i++) {
            TIMES[i][0] = SC.nextInt();
            TIMES[i][1] = SC.nextInt();
        }
    }
}
