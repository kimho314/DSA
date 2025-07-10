package boj;

import java.util.*;

public class BOJ17298 {
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
        int[] nge = new int[N];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = N - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= A[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = stack.peek();
            }

            stack.push(A[i]);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(nge[i]).append(" ");
        }
        System.out.println(sb);
    }
}
