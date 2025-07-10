package boj;

public class BOJ28324 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] V;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] newV = new int[N];
        newV[N - 1] = 1;

        for (int i = N - 2; i >= 0; i--) {
            int n = newV[i + 1] + 1;
            if (n <= V[i]) {
                newV[i] = n;
            }
            else {
                newV[i] = V[i];
            }
        }

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += newV[i];
        }
        System.out.println(sum);
    }

    private static void input() {
        N = SC.nextInt();
        V = new int[N];
        for (int i = 0; i < N; i++) {
            V[i] = SC.nextInt();
        }
    }
}
