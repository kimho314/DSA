package boj;

import java.util.Arrays;

public class BOJ12018 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int CNT = 0;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int p = SC.nextInt();
            int l = SC.nextInt();
            int[] mileage = new int[p];
            for (int j = 0; j < p; j++) {
                mileage[j] = SC.nextInt();
            }

            int diff = p - l;
            if (diff < 0) {
                arr[i] = 1;
            }
            else {
                Arrays.sort(mileage);
                arr[i] = mileage[diff];
            }
        }

        Arrays.sort(arr);
        for (int elem : arr) {
            if (M - elem < 0) {
                break;
            }
            M -= elem;
            CNT++;
        }

        System.out.println(CNT);
    }
}
