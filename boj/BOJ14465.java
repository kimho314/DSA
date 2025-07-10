package boj;

public class BOJ14465 {
    private static FastReader SC = new FastReader();
    private static int N, K, B;
    private static boolean[] TRAFFIC;

    public static void main(String[] args) {
        input();
//        solve();
        solve2();
    }

    private static void solve2() {
        int[] sums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sums[i] = sums[i - 1] + (TRAFFIC[i] ? 1 : 0);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N - K + 1; i++) {
            int cnt = sums[i + K - 1] - sums[i - 1];
//            System.out.println(cnt + " " + sums[i + K - 1] + " " + sums[i - 1] + " " + i);
            res = Math.min(res, cnt);
        }
        System.out.println(res);
    }

    //    private static void solve() {
//        int res = Integer.MAX_VALUE;
//        for (int i = 1; i <= N - K + 1; i++) {
//            int cnt = 0;
//            for (int j = i; j < i + K; j++) {
//                if (TRAFFIC[j]) {
//                    cnt++;
//                }
//            }
//            res = Math.min(res, cnt);
//        }
//
//        System.out.println(res);
//    }
//
    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        B = SC.nextInt();
        TRAFFIC = new boolean[N + 1];
        for (int i = 0; i < B; i++) {
            int n = SC.nextInt();
            TRAFFIC[n] = true;
        }
    }
}
