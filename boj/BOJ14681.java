package boj;

public class BOJ14681 {
    private static FastReader SC = new FastReader();
    private static int X, Y;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;
        if (X > 0 && Y > 0) {
            res = 1;
        }
        else if (X < 0 && Y > 0) {
            res = 2;
        }
        else if (X < 0 && Y < 0) {
            res = 3;
        }
        else {
            res = 4;
        }

        System.out.println(res);
    }

    private static void input() {
        X = SC.nextInt();
        Y = SC.nextInt();
    }
}
