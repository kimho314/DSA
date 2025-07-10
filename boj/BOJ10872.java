package boj;

public class BOJ10872 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        int[] dp = new int[13];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 12; i++) {
            dp[i] = i * dp[i - 1];
        }
        System.out.println(dp[N]);
    }
}
