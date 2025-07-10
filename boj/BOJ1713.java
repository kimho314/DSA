package boj;

import java.util.Collections;
import java.util.LinkedList;

public class BOJ1713 {
    private static FastReader SC = new FastReader();
    private static int N, CNT;
    private static int[] STUDENTS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        LinkedList<Integer> list = new LinkedList<>();
        int[] n = new int[101];

        for (int i = 0; i < CNT; i++) {
            n[STUDENTS[i]]++;
            if (!list.contains(STUDENTS[i])) {
                if (list.size() >= N) {
                    int min = Integer.MAX_VALUE;
                    for (Integer elem : list) {
                        if (min > n[elem]) {
                            min = n[elem];
                        }
                    }
                    for (Integer elem : list) {
                        if (n[elem] == min) {
                            list.remove(elem);
                            n[elem] = 0;
                            break;
                        }
                    }

                }
                list.addLast(STUDENTS[i]);
            }
        }

        Collections.sort(list);
        for (Integer elem : list) {
            System.out.print(elem + " ");
        }
    }

    private static void input() {
        N = SC.nextInt();
        CNT = SC.nextInt();
        STUDENTS = new int[CNT];
        for (int i = 0; i < CNT; i++) {
            STUDENTS[i] = SC.nextInt();
        }
    }
}
