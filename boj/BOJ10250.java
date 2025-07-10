package boj;

public class BOJ10250 {
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

            int h = SC.nextInt();
            int w = SC.nextInt();
            int n = SC.nextInt();

            int y = n % h == 0 ? h : n % h;
            int x = (n - y) / h + 1;
//            System.out.println(y + " " + x);

            String res = y + String.format("%02d", x);
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }

    private static void input() {
        T = SC.nextInt();
    }
}
