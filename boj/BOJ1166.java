package boj;

public class BOJ1166 {
    static FastReader SC = new FastReader();
    static int N, L, W, H;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        double l = 0.0;
        double r = Math.min(L, Math.min(W, H));
        double res = 0.0;
        while (l < r) {
            double mid = (l + r) / 2.0;
            if (determine(mid)) {
                if (l == mid) {
                    break;
                }
                l = mid;
                res = mid;
            }
            else {
                if (r == mid) {
                    break;
                }
                r = mid;
            }
        }
        System.out.println(res);
    }

    private static boolean determine(double mid) {
        return (long) (L / mid) * (long) (W / mid) * (long) (H / mid) >= N;
    }

    private static void input() {
        N = SC.nextInt();
        L = SC.nextInt();
        W = SC.nextInt();
        H = SC.nextInt();
    }
}
