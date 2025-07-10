package boj;

public class BOJ2559 {
    static FastReader sc = new FastReader();
    static int K;
    static int N;
    static int[] NUMS;

    public static void main(String[] args) {
        N = sc.nextInt();
        K = sc.nextInt();
        NUMS = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            NUMS[i] = sc.nextInt();
        }

        int right = 0;
        int bestSum = Integer.MIN_VALUE;
        int prevSum = 0;
        for (int left = 1; left <= N - K + 1; left++) {
            int sum = prevSum - NUMS[left - 1];

            while (right + 1 <= N && right < left + K - 1) {
                sum += NUMS[++right];
            }

            prevSum = sum;
            bestSum = Math.max(bestSum, sum);
        }

        System.out.println(bestSum);
    }
}
