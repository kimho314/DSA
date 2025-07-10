package boj;

import java.math.BigInteger;

public class BOJ1676 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static BigInteger[] DP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        DP = new BigInteger[501];
        DP[0] = BigInteger.ZERO;
        DP[1] = BigInteger.ONE;
        for (int i = 2; i <= 500; i++) {
            DP[i] = BigInteger.valueOf(i).multiply(DP[i - 1]);
        }

        long cnt = 0;
        if (N == 0) {
            System.out.println(cnt);
            return;
        }
        char[] chs = DP[N].toString().toCharArray();
        for (int i = chs.length - 1; i >= 0; i--) {
            if (chs[i] != '0') {
                break;
            }
            if (chs[i] == '0') {
                cnt++;
            }
        }

        System.out.println(cnt);
    }


    private static void input() {
        N = SC.nextInt();
    }
}
