package boj;

public class BOJ2525 {
    private static FastReader SC = new FastReader();
    private static int A, B, C;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int time = A * 60 + B + C;

        int hour = (time / 60) % 24;
        int minute = time % 60;
        System.out.println(hour + " " + minute);
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
        C = SC.nextInt();
    }
}
