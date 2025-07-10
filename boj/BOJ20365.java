package boj;

public class BOJ20365 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static char[] CHARS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cntB = 0;
        int cntR = 0;
        if (CHARS[0] == 'R') {
            cntR++;
        } else {
            cntB++;
        }

        for (int i = 1; i < N; i++) {
            if (CHARS[i - 1] != CHARS[i]) {
                if (CHARS[i] == 'R') {
                    cntR++;
                } else {
                    cntB++;
                }
            }
        }

        // System.out.println(cntR + " " + cntB);

        int res = 1;
        if (cntR >= cntB) {
            res += cntB;
        } else {
            res += cntR;
        }
        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        CHARS = SC.nextLine().toCharArray();
    }
}
