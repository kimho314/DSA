package boj;

public class BOJ10972 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }

    private static void solve() {
        if (nextPerm()) {
            for (int i = 0; i < N; i++) {
                System.out.print(A[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static boolean nextPerm() {
        int idx = N - 1;
        while (idx > 0) {
            if (A[idx] > A[idx - 1]) {
                break;
            }
            idx--;
        }

        if (idx == 0) {
            return false;
        }

        int cmp = idx - 1;
        int idx2 = N - 1;
        while (A[cmp] >= A[idx2]) {
            idx2--;
        }
        // System.out.println(idx + " " + cmp + " " + idx2);
        swap(cmp, idx2);

        int r = N - 1;
        int l = idx;
        while (l < r) {
            swap(l, r);
            l++;
            r--;
        }

        return true;
    }

    private static void swap(int n1, int n2) {
        int tmp = A[n1];
        A[n1] = A[n2];
        A[n2] = tmp;
    }
}
