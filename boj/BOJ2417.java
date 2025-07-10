package boj;

import java.math.BigInteger;

public class BOJ2417 {
    private static FastReader SC = new FastReader();
    private static long N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        BigInteger l = BigInteger.ZERO;
        BigInteger r = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger res = BigInteger.ZERO;
        while (l.compareTo(r) <= 0) {
            BigInteger mid = l.add(r).divide(BigInteger.valueOf(2));
            // System.out.println(mid + " " + mid * mid);
            if (mid.multiply(mid).compareTo(BigInteger.valueOf(N)) >= 0) {
                res = mid;
                r = mid.subtract(BigInteger.ONE);
            } else {
                l = mid.add(BigInteger.ONE);
            }
        }
        System.out.println(res);
    }

    private static void input() {
        N = SC.nextLong();
    }
}
