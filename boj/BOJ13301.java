package boj;

import java.math.BigInteger;

public class BOJ13301 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        BigInteger[][] D = new BigInteger[81][2];

        D[0][0] = BigInteger.valueOf(0);
        D[0][1] = BigInteger.valueOf(0);
        D[1][0] = BigInteger.valueOf(1);
        D[1][1] = BigInteger.valueOf(4);
        D[2][0] = BigInteger.valueOf(1);
        D[2][1] = BigInteger.valueOf(6);
        for (int i = 3; i <= 80; i++) {
            D[i][0] = D[i - 1][0].add(D[i - 2][0]);
            D[i][1] = D[i][0].multiply(BigInteger.valueOf(2)).add(D[i][0].add(D[i - 1][0]).multiply(BigInteger.valueOf(2)));
        }

        System.out.println(D[N][1]);
    }
}
