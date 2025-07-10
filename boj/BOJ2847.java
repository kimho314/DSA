package boj;

public class BOJ2847 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }

        int res = 0;
        for (int i = N - 2; i >= 0; i--) {
            if (A[i] >= A[i + 1]) {
                res += Math.abs(A[i + 1] - 1 - A[i]);
                A[i] = A[i + 1] - 1;
            }
        }
        System.out.println(res);
    }
}
