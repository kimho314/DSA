package boj;

public class BOJ2884 {
    static FastReader SC = new FastReader();
    static int H, M;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int max = 24 * 60;
        int converted = (H * 60 + M) - 45;
        if (converted < 0) {
            converted = max + converted;
        }
        int h = converted / 60;
        int m = converted % 60;

        System.out.println(h + " " + m);
    }

    private static void input() {
        H = SC.nextInt();
        M = SC.nextInt();
    }
}
