package boj;

public class BOJ21735 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] A;
    private static int MAX;
    private static final int[] DIR = {1, 2};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        recFunc(0, 0, A[0]);

        System.out.println(MAX);
    }

    private static void recFunc(int k, int idx, int sum) {
//        System.out.println(k + " " + idx + " " + A[idx] + " " + sum);
        if (k == M || idx == N) {
            MAX = Math.max(MAX, sum);
//            System.out.println();
        }
        else {
            for (int i = 0; i < 2; i++) {
                int next = idx + DIR[i];
                if (next > N) {
                    return;
                }
                if (DIR[i] == 1) {
                    recFunc(k + 1, next, sum + A[next]);
                }
                if (DIR[i] == 2) {
                    recFunc(k + 1, next, (sum / 2) + A[next]);
                }
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new int[N + 1];
        A[0] = 1;
        for (int i = 1; i <= N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
