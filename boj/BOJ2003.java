package boj;

public class BOJ2003 {
    static int N, M;
    static int[] NUMS;
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        NUMS = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            NUMS[i] = sc.nextInt();
        }


        int right = 0;
        int sum = 0;
        int ans = 0;

        for (int left = 1; left <= N; left++) {
            sum -= NUMS[left - 1];

            while (right + 1 <= N && sum < M) {
                sum += NUMS[++right];
            }

            if (sum == M) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
