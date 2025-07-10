package boj;

public class BOJ9316 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static String STR = "Hello World, Judge";

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            String str = String.format(STR + " %d!", i + 1);
            System.out.println(str);
        }
    }

    private static void input() {
        N = SC.nextInt();
    }
}
