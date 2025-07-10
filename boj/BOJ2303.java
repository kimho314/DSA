package boj;

public class BOJ2303 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] NUMS;
    private static int[] MAX;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            recFunc(i, NUMS[i], -1, 0, 0, new int[3]);
        }

//        System.out.println(Arrays.toString(MAX));
        int maxIdx = 0;
        for (int i = 1; i < N; i++) {
            if (MAX[maxIdx] <= MAX[i]) {
                maxIdx = i;
            }
        }
        System.out.println(maxIdx + 1);
    }

    private static void recFunc(int idx, int[] nums, int prevIdx, int k, int sum, int[] selected) {
        if (k == 3) {
//            System.out.println(idx + " " + sum + " " + Arrays.toString(selected));
            if (MAX[idx] < sum % 10) {
                MAX[idx] = sum % 10;
            }
        }
        else {
            for (int i = prevIdx + 1; i < 5; i++) {
                selected[k] = nums[i];
                recFunc(idx, nums, i, k + 1, sum + nums[i], selected);
                selected[k] = 0;
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        NUMS = new int[N][5];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                NUMS[i][j] = SC.nextInt();
            }
        }
        MAX = new int[N];
    }
}
