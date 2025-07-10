package boj;

public class BOJ15552 {
    private static FastReader SC = new FastReader();
    private static int T;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        while (T > 0) {
            T--;

            int a = SC.nextInt();
            int b = SC.nextInt();
            int res = a + b;
            sb.append(res).append('\n');
        }

        System.out.println(sb);
    }

    private static void input() {
        T = SC.nextInt();
    }
}
