package boj;

public class BOJ20055 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        boolean[] belt = new boolean[N];
        int step = 0;
        while (check()) {
            step++;

            int temp = A[N * 2 - 1];
            for (int i = N * 2 - 1; i > 0; i--) {
                A[i] = A[i - 1];
            }
            A[0] = temp;

            for (int i = N - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = false;
            belt[N - 1] = false;

            for (int i = N - 1; i > 0; i--) {
                if (!belt[i - 1] || belt[i] || A[i] < 1) {
                    continue;
                }

                A[i]--;
                belt[i] = true;
                belt[i - 1] = false;
            }

            if (A[0] <= 0) {
                continue;
            }
            belt[0] = true;
            A[0]--;
        }

        System.out.println(step);
    }

    private static boolean check() {
        int cnt = 0;
        for (int i : A) {
            if (i == 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }
        return true;
    }


    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        A = new int[N * 2];
        for (int i = 0; i < A.length; i++) {
            A[i] = SC.nextInt();
        }
    }
}
