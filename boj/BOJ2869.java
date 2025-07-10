package boj;

public class BOJ2869 {
    private static FastReader SC = new FastReader();
    private static int A, B, V;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int day = (V - B) / (A - B);
        if (((V - B) % (A - B)) != 0) {
            day++;
        }
        System.out.println(day);
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
        V = SC.nextInt();
    }
}
