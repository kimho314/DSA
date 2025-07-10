package boj;

public class BOJ2711 {
    static FastReader SC = new FastReader();
    static int T;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        while (T > 0) {
            T--;
            solve();
        }
        System.out.println(SB.toString());
    }

    private static void solve() {
        int idx = SC.nextInt();
        String str = SC.next();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == idx - 1) {
                continue;
            }

            sb.append(str.charAt(i));
        }

        SB.append(sb.toString()).append('\n');
    }

    private static void input() {
        T = SC.nextInt();
    }
}
