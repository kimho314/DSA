package boj;

public class BOJ10973 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        NUMS = new int[N];
        for (int i = 0; i < N; i++) {
            NUMS[i] = SC.nextInt();
        }
    }

    private static void solve() {
        if (prevPerm()) {
            for (int i = 0; i < N; i++) {
                System.out.print(NUMS[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static boolean prevPerm() {
        int idx = N - 1;
        while (idx > 0) {
            if (NUMS[idx] > NUMS[idx - 1]) {
                idx--;
            } else {
                break;
            }
        }
        if (idx == 0) {
            return false;
        }
        int i = idx - 1;
        int j = N - 1;
        while (j > idx && NUMS[j] >= NUMS[i]) {
            j--;
        }
        swap(i, j);

        int l = idx;
        int r = N - 1;
        while (l < r) {
            swap(r, l);
            l++;
            r--;
        }

        return true;
    }

    private static void swap(int i, int j) {
        int tmp = NUMS[i];
        NUMS[i] = NUMS[j];
        NUMS[j] = tmp;
    }
}
