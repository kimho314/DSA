package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ13164 {
    static FastReader SC = new FastReader();
    static int N, K;
    static int[] A;

    public static void main(String[] args) {
        N = SC.nextInt();
        K = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }

        Arrays.sort(A);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            list.add(A[i] - A[i - 1]);
        }
        Collections.sort(list);
        int result = 0;
        for (int i = 0; i < N - K; i++) {
            result += list.get(i);
        }
        System.out.println(result);
    }
}
