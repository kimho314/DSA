package boj;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ2529 {
    static FastReader SC = new FastReader();
    static int K;
    static String[] SIGNS;
    static int[] SELECTED;
    static boolean[] USED;
    static String MIN = String.valueOf(Long.MAX_VALUE), MAX = String.valueOf(Long.MIN_VALUE);

    public static void main(String[] args) {
        K = SC.nextInt();
        SIGNS = new String[K];
        for (int i = 0; i < K; i++) {
            SIGNS[i] = SC.next();
        }
        SELECTED = new int[K + 1];
        Arrays.fill(SELECTED, -1);
        USED = new boolean[10];

        recFunc(0);

//        System.out.println("=========");
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void recFunc(int k) {
        if (k == K + 1) {
            boolean isTrue = true;
            for (int i = 0; i < SIGNS.length; i++) {
                switch (SIGNS[i]) {
                    case "<":
                        isTrue = SELECTED[i] < SELECTED[i + 1];
                        break;
                    case ">":
                        isTrue = SELECTED[i] > SELECTED[i + 1];
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                if (!isTrue) {
                    break;
                }
            }
            if (!isTrue) {
                return;
            }

            String numString = Arrays.stream(SELECTED).mapToObj(String::valueOf).collect(Collectors.joining());
            Long num = Long.parseLong(numString);
//            System.out.println(num);
            if (Long.parseLong(MIN) > num) {
                MIN = numString;
            }
            if (Long.parseLong(MAX) < num) {
                MAX = numString;
            }
        }
        else {
            for (int i = 0; i < 10; i++) {
                if (!USED[i]) {
                    USED[i] = true;
                    SELECTED[k] = i;
                    recFunc(k + 1);
                    SELECTED[k] = -1;
                    USED[i] = false;
                }
            }
        }
    }
}
