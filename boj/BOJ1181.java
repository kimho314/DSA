package boj;

import java.util.*;

public class BOJ1181 {
    static int N;
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        N = SC.nextInt();
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = SC.next();
        }

        Set<String> set = new HashSet<>(Arrays.asList(words).subList(0, N));
        List<String> list = new ArrayList<>(set);
        list.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
        list.forEach(System.out::println);

    }
}
