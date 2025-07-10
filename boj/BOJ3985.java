package boj;

public class BOJ3985 {
    private static FastReader SC = new FastReader();
    private static int L, N;
    private static int[][] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            int len = NUMS[i][1] - NUMS[i][0] + 1;
            if (len > max) {
                max = len;
                maxIdx = i + 1;
            }
        }

        int[] cake = new int[L];
        for (int i = 0; i < N; i++) {
            for (int j = NUMS[i][0] - 1; j <= NUMS[i][1] - 1; j++) {
                if (cake[j] > 0) {
                    continue;
                }
                cake[j] = NUMS[i][2];
            }
        }

        int[] counts = new int[N];
        for (int i = 0; i < L; i++) {
            if (cake[i] == 0) {
                continue;
            }

            counts[cake[i] - 1]++;
        }

        int realMax = 0;
        int realMaxIdx = 0;
        for (int i = 0; i < N; i++) {
            if (realMax < counts[i]) {
                realMax = counts[i];
                realMaxIdx = i + 1;
            }
        }

        System.out.println(maxIdx);
        System.out.println(realMaxIdx);
    }

    private static void input() {
        L = SC.nextInt();
        N = SC.nextInt();
        NUMS = new int[N][3];
        for (int i = 0; i < N; i++) {
            int p = SC.nextInt();
            int k = SC.nextInt();
            NUMS[i][0] = p;
            NUMS[i][1] = k;
            NUMS[i][2] = i + 1;
        }
    }
}
