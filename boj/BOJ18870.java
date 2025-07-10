package boj;

import java.util.*;

public class BOJ18870 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] X;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        N = SC.nextInt();
        X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = SC.nextInt();
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(X[i]);
        }
        Set<Integer> set = new HashSet<>(list);
        list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(it -> it));

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (map.getOrDefault(list.get(i), -1) == -1) {
                map.put(list.get(i), i);
            }
        }

        for (int i = 0; i < N; i++) {
            SB.append(map.get(X[i])).append(' ');
        }
        System.out.println(SB.toString());
    }
}
