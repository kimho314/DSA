package boj;

import java.util.Arrays;

public class BOJ14650 {
    static FastReader SC = new FastReader();
    static int N, CNT = 0;
    static int[] SELECTED;

    public static void main(String[] args) {
        N = SC.nextInt();
        SELECTED = new int[N + 1];
        Arrays.fill(SELECTED, -1);

        recFunc(1);
//        System.out.println("=========");
        System.out.println(CNT);
    }

    private static void recFunc(int k) {
        if (k == N + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                sb.append(SELECTED[i]);
            }

            if (Integer.parseInt(sb.toString()) % 3 == 0) {
//                System.out.println(sb.toString());
                CNT++;
            }
        }
        else {
            for (int i = 0; i < 3; i++) {
                if (k == 1 && i == 0) {
                    continue;
                }

                SELECTED[k] = i;
                recFunc(k + 1);
                SELECTED[k] = -1;
            }
        }
    }
}
