package boj;

public class BOJ1476 {
    private static FastReader SC = new FastReader();
    private static int E, S, M;
    private static int MOD_E = 15;
    private static int MOD_S = 28;
    private static int MOD_M = 19;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int year = 1;
        while (true) {
            int remainderE = year % MOD_E;
            int remainderS = year % MOD_S;
            int remainderM = year % MOD_M;
            if (remainderE == 0) {
                remainderE = MOD_E;
            }
            if (remainderS == 0) {
                remainderS = MOD_S;
            }
            if (remainderM == 0) {
                remainderM = MOD_M;
            }

//            System.out.println(remainderE + " " + remainderS + " " + remainderM + " " + year);
            if (remainderE == E && remainderS == S && remainderM == M) {
                break;
            }

            year++;
        }

        System.out.println(year);
    }

    private static void input() {
        E = SC.nextInt();
        S = SC.nextInt();
        M = SC.nextInt();
    }
}
