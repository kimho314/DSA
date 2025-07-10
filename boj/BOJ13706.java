package boj;

import java.math.BigInteger;

public class BOJ13706 {
    static FastReader SC = new FastReader();
    static BigInteger N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        BigInteger l = BigInteger.ONE;
        BigInteger r = N;
        BigInteger res = BigInteger.ZERO;
        while (l.compareTo(r) <= 0) {
            BigInteger mid = (l.add(r)).divide(new BigInteger(String.valueOf(2)));
            if (mid.multiply(mid).equals(N)) {
                res = mid;
                break;
            }
            else if (mid.multiply(mid).compareTo(N) < 0) {
                l = mid.add(BigInteger.ONE);
            }
            else {
                r = mid.subtract(BigInteger.ONE);
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = new BigInteger(SC.next());
    }
}
