package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BOJ12101 {
    static FastReader SC = new FastReader();
    static int N, K;
    static List<Integer> SELECTED = new ArrayList<>();
    static List<String> SUMS = new ArrayList<>();

    public static void main(String[] args) {
        N = SC.nextInt();
        K = SC.nextInt();
        int[] arr = new int[]{1, 2, 3};

        recFunc(arr, 0);

        SUMS.sort(Comparator.naturalOrder());
        if (SUMS.size() > K - 1) {
            System.out.println(String.join("+", SUMS.get(K - 1).split("")));
        }
        else {
            System.out.println(-1);
        }
    }

    private static void recFunc(int[] arr, int sum) {
        if (sum == N) {
            StringBuilder sb = new StringBuilder();
            SELECTED.forEach(sb::append);
            SUMS.add(sb.toString());
        }
        else {
            for (int i = 0; i < 3; i++) {
                int num = arr[i];
                int tempSum = sum + num;
                if (tempSum <= N) {
                    SELECTED.add(num);
                    recFunc(arr, tempSum);
                    SELECTED.remove(SELECTED.size() - 1);
                }
            }
        }
    }
}
