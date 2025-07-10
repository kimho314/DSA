package boj;

import java.math.BigInteger;

public class BOJ9711 {
    static FastReader SC = new FastReader();
    static int T;
    static BigInteger[] DP = new BigInteger[10_001];
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();

        DP[1] = BigInteger.ONE;
        DP[2] = BigInteger.ONE;
        for (int i = 3; i <= 10000; i++) {
            DP[i] = DP[i - 1].add(DP[i - 2]);
        }

        int num = 1;
        while (num <= T) {
            int p = SC.nextInt();
            int q = SC.nextInt();

            String res = String.format("Case #%d: %d", num, DP[p].mod(BigInteger.valueOf(q)));
            SB.append(res).append('\n');
            num++;
        }
        System.out.println(SB.toString());
    }
}
