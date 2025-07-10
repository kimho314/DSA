package boj;

public class BOJ2742 {
    private static FastReader SC = new FastReader();
    private static int N;


    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = N; i > 0; i--) {
            System.out.println(i);
        }
    }

    private static void input() {
        N = SC.nextInt();
    }
}
