package boj;

import java.util.*;

public class BOJ7785 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        N = SC.nextInt();
        for (int i = 0; i < N; i++) {
            String name = SC.next();
            String status = SC.next();
            if (status.equals("leave")) {
                set.remove(name);
            }
            else {
                set.add(name);
            }
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Comparator.reverseOrder());
        list.forEach(System.out::println);
    }
}
