package boj;

public class BOJ1330 {
    private static FastReader SC = new FastReader();
    private static int A, B;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        if (A > B) {
            System.out.println(">");
        }
        else if (A < B) {
            System.out.println("<");
        }
        else {
            System.out.println("==");
        }
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
    }
}
