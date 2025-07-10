package boj;

public class BOJ15565 {
    static FastReader sc = new FastReader();
    static int N;
    static int K;
    static int[] NUMS;

    public static void main(String[] args) {
        N = sc.nextInt();
        K = sc.nextInt();
        NUMS = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            NUMS[i] = sc.nextInt();
        }

        int bestSize = Integer.MAX_VALUE;
        int right = 0;
        int size = 1;
        int cnt = 0;
        for (int left = 1; left <= N; left++) {
            if (left > 1 && NUMS[left - 1] == 1) {
                cnt--;
            }
            size--;

            while (right + 1 <= N && cnt < K) {
                size++;
                if (NUMS[++right] == 1) {
                    cnt++;
                }
            }

            if (cnt >= K) {
                bestSize = Math.min(bestSize, size);
            }
        }

        if (bestSize == Integer.MAX_VALUE) {
            bestSize = -1;
        }
        System.out.println(bestSize);
    }
}
