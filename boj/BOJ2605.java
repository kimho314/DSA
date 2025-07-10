package boj;

public class BOJ2605 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] students = new int[N];
        for (int i = 0; i < N; i++) {
            students[i] = i + 1;
        }

        for (int i = 0; i < N; i++) {
            int n = NUMS[i];
            if (n == 0) {
                continue;
            }

            int target = i - n;
            int tmp = students[i];
            for (int j = i - 1; j >= target; j--) {
                students[j + 1] = students[j];
            }
            students[target] = tmp;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(students[i] + " ");
        }
    }

    private static void input() {
        N = SC.nextInt();
        NUMS = new int[N];
        for (int i = 0; i < N; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
