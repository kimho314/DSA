package boj;

import java.util.Arrays;

public class BOJ22993 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] copy = Arrays.copyOfRange(A, 1, N);
        Arrays.sort(copy);

        long power = A[0];
        boolean isWin = true;
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] >= power) {
                isWin = false;
                break;
            }

            if (copy[i] < power) {
                power += copy[i];
            }
        }

        System.out.println(isWin ? "Yes" : "No");
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
