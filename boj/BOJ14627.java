package boj;

public class BOJ14627 {
    static FastReader SC = new FastReader();
    static int S, C;
    static Integer[] L;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long l = 1;
        long r = 1_000_000_000;
        long sum = 0;
        for (int i = 0; i < S; i++) {
            sum += L[i];
        }

        long res = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
//            System.out.println(mid + " " + l + " " + r);
            if (determine(mid)) {
                l = mid + 1;
                res = mid;
            }
            else {
                r = mid - 1;
            }
        }

        System.out.println(sum - (res * C));
    }

    private static boolean determine(long mid) {
        long cnt = 0;
        for (int i = 0; i < S; i++) {
            cnt += (long) L[i] / mid;
        }
        return cnt >= C;
    }

    private static void input() {
        S = SC.nextInt();
        C = SC.nextInt();
        L = new Integer[S];
        for (int i = 0; i < S; i++) {
            L[i] = SC.nextInt();
        }
    }
}
