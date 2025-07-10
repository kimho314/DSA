package boj;

public class BOJ12782 {
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
        String n = SC.next();
        String m = SC.next();
        int cntZero = 0;
        int cntOne = 0;

        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) != m.charAt(i)) {
                if (m.charAt(i) == '0') {
                    cntZero++;
                }
                if (m.charAt(i) == '1') {
                    cntOne++;
                }
            }
        }

        if (cntZero >= cntOne) {
            SB.append(cntZero).append('\n');
        }
        else {
            SB.append(cntOne).append('\n');
        }
    }

    private static void input() {
        T = SC.nextInt();
    }
}
