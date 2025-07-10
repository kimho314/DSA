package boj;

import java.util.Arrays;

public class BOJ16435 {
    static FastReader SC = new FastReader();
    static int N, L;
    static int[] H;

    public static void main(String[] args) {
        N = SC.nextInt();
        L = SC.nextInt();
        H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = SC.nextInt();
        }
        Arrays.sort(H);

        int height = L;
        for (int i = 0; i < N; i++) {
            if (height >= H[i]) {
                height++;
            }
        }
        System.out.println(height);
    }
}
