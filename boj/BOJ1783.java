package boj;

public class BOJ1783 {
    private static FastReader SC = new FastReader();
    private static int N, M;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        if (N == 1) {
            System.out.println(1);
            return;
        }
        if (N == 2) {
            System.out.println(Math.min(4, (M + 1) / 2));
            return;
        }
        if (N >= 3) {
            if (M < 7) {
                System.out.println(Math.min(4, M));
            }
            else {
                System.out.println(M - 2);
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
    }
}
