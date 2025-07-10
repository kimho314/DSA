package boj;

public class BOJ9295 {
    private static FastReader SC = new FastReader();
    private static int T;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            int sum = n1 + n2;
            sb.append("Case").append(" ").append(i).append(":").append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }

    private static void input() {
        T = SC.nextInt();
    }
}
