package boj;

import java.util.Arrays;

public class BOJ10816 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
        M = SC.nextInt();
        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = SC.nextInt();
        }

        Arrays.sort(A);

        for (int i = 0; i < M; i++) {
            int low = lowerBound(A, 0, A.length - 1, B[i]);
            int upper = upperBound(A, 0, A.length - 1, B[i]);
            SB.append(upper - low).append(' ');
        }

        System.out.println(SB);
    }

    private static int lowerBound(int[] A, int left, int right, int target) {
        int ans = right + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] >= target) {
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private static int upperBound(int[] A, int left, int right, int target) {
        int ans = right + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] > target) {
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;


    }
}
