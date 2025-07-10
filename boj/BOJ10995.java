package boj;

public class BOJ10995 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (i % 2 == 1) {
                sb.append(" ");
            }
            for (int j = 0; j < N; j++) {
                sb.append("*").append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
