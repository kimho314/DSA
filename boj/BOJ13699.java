package boj;

public class BOJ13699 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();

        long[] dp = new long[36];
        dp[0] = 1;
        for (int i = 1; i <= 35; i++) {
            long sum = 0;
            for (int j = 0; j < i; j++) {
                sum += (dp[j] * dp[i - 1 - j]);
            }
            dp[i] = sum;
        }
        System.out.println(dp[N]);
    }
}
