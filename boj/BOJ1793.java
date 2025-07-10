package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ1793 {
    static FastReader SC = new FastReader();
    static BigInteger[] DP = new BigInteger[251];

    public static void main(String[] args) throws IOException {
        DP[0] = new BigInteger("1");
        DP[1] = new BigInteger("1");
        DP[2] = new BigInteger("3");

        for (int i = 3; i <= 250; i++) {
            DP[i] = DP[i - 1].add(DP[i - 2].multiply(new BigInteger("2")));
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            System.out.println(DP[n]);
        }

    }
}
