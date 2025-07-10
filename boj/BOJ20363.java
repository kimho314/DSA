package boj;

public class BOJ20363 {
    private static FastReader SC = new FastReader();
    private static int X, Y;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;
        if (X >= Y) {
            res = X + (Y / 10) + Y;
        } else {
            res = Y + (X / 10) + X;
        }

        System.out.println(res);
    }

    private static void input() {
        X = SC.nextInt();
        Y = SC.nextInt();
    }
}
