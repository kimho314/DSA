package boj;

import java.util.Arrays;

public class BOJ1764 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();
    static int N, M;
    static String[] A;
    static String[] B;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new String[N];
        B = new String[M];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextLine();
        }
        for (int i = 0; i < M; i++) {
            B[i] = SC.nextLine();
        }

        Arrays.sort(A);
        Arrays.sort(B);
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            int idx = searchMatchingString(A[i], B, 0, B.length - 1);
            if (idx != -1) {
                cnt++;
                SB.append(A[i]).append('\n');
            }
        }

        System.out.println(cnt);
        System.out.println(SB);
    }

    private static int searchMatchingString(String str, String[] input, int left, int right) {
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (str.compareTo(input[mid]) < 0) {
                right = mid - 1;
            }
            else if (str.compareTo(input[mid]) > 0) {
                left = mid + 1;
            }
            else {
                res = mid;
                break;
            }
        }

        return res;
    }
}
