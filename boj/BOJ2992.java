package boj;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ2992 {
    static FastReader SC = new FastReader();
    static String X;
    static int[] NUMS = new int[10];
    static int[] SELECTED;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        X = SC.nextLine();
        for (int i = 0; i < X.length(); i++) {
            NUMS[Integer.parseInt(String.valueOf(X.charAt(i)))]++;
        }
        SELECTED = new int[X.length()];
        Arrays.fill(SELECTED, -1);

        recFunc(0);

        if (MIN == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.println(MIN);
        }
    }

    private static void recFunc(int k) {
        if (k == X.length()) {
            String s = Arrays.stream(SELECTED).mapToObj(String::valueOf).collect(Collectors.joining(""));
//            System.out.println(s);
            if (Integer.parseInt(s) <= Integer.parseInt(X)) {
                return;
            }
            int cnt = 0;
            for (int i = 0; i < X.length(); i++) {
                int idx = X.indexOf(String.valueOf(SELECTED[i]));
                if (idx != -1) {
                    cnt++;
                }
            }

            if (cnt == X.length()) {
                MIN = Math.min(MIN, Integer.parseInt(s));
            }
        }
        else {
            for (int i = 0; i < 10; i++) {
                if (k == 0 && i == 0) {
                    continue;
                }

                if (NUMS[i] > 0) {
                    NUMS[i]--;
                    SELECTED[k] = i;
                    recFunc(k + 1);
                    NUMS[i]++;
                    SELECTED[k] = -1;
                }
            }
        }
    }
}
