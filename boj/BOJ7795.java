package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ7795 {
    static Scanner sc = new Scanner(System.in);
    static int T;
    static int[][] A, B;

    static int binarySearch(int[] arr, int l, int r, int key) {
        int result = l - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] < key) {
                result = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return result + 1;
    }

    public static void main(String[] args) {
        T = sc.nextInt();
        A = new int[T][];
        B = new int[T][];
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            A[i] = new int[N];
            B[i] = new int[M];
            for (int idx = 0; idx < N; idx++) {
                A[i][idx] = sc.nextInt();
            }
            for (int idx = 0; idx < M; idx++) {
                B[i][idx] = sc.nextInt();
            }
        }

        for (int i = 0; i < T; i++) {
            int answer = 0;
            Arrays.sort(B[i]);
            for (int a : A[i]) {
                answer += binarySearch(B[i], 0, B[i].length - 1, a);
            }
            System.out.println(answer);
        }
    }
}
