package boj;

public class BOJ11557 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();

        while (T > 0) {
            T--;
            solve();
        }

        System.out.println(SB.toString());
    }

    private static void solve() {
        int n = SC.nextInt();

        int max = 0;
        String name = null;
        for (int i = 0; i < n; i++) {
            String s = SC.next();
            int l = SC.nextInt();
            if (max < l) {
                max = l;
                name = s;
            }
        }

        SB.append(name).append("\n");
    }

    private static void input() {
        T = SC.nextInt();
    }
}
