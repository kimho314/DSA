package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BOJ28062 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }

        int res = 0;
        List<Integer> odds = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (A[i] % 2 == 0) {
                res += A[i];
            }
            else {
                odds.add(A[i]);
            }
        }

        if (odds.size() % 2 == 0) {
            res += odds.stream().mapToInt(Integer::intValue).sum();
        }
        else {
            odds.sort(Comparator.naturalOrder());
            res += odds.stream().skip(1).mapToInt(Integer::intValue).sum();
        }
        System.out.println(res);
    }
}
