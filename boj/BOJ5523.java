package boj;

public class BOJ5523 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] A, B;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int winA = 0;
        int winB = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] > B[i]) {
                winA++;
            }
            if (A[i] < B[i]) {
                winB++;
            }
        }

        System.out.println(winA + " " + winB);
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
            B[i] = SC.nextInt();
        }
    }
}
