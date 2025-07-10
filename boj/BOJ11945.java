package boj;

public class BOJ11945 {
    static FastReader SC = new FastReader();
    static int N, M;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        while (N > 0) {
            N--;

            String str = SC.nextLine();
            StringBuilder res = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                res.append(str.charAt(i));
            }

            SB.append(res).append('\n');
        }
        System.out.println(SB.toString());
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
    }
}
