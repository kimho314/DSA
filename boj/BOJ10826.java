package boj;

import java.math.BigInteger;

public class BOJ10826 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        BigInteger[] fib = new BigInteger[10001];
        fib[0] = BigInteger.valueOf(0);
        fib[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= 10000; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }
        System.out.println(fib[N]);
    }
}
