package boj;

public class BOJ14912 {
    private static FastReader SC = new FastReader();
    private static int N, D;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long cnt = 0;

        for (int i = 1; i <= N; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if (D == Integer.parseInt(str.charAt(j) + "")) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    private static void input() {
        N = SC.nextInt();
        D = SC.nextInt();
    }
}
