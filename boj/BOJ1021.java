package boj;

import java.util.LinkedList;

public class BOJ1021 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[] POSITIONS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int res = 0;

        for (int i = 0; i < M; i++) {
            int targetIdx = list.indexOf(POSITIONS[i]);
            int halfIdx = list.size() % 2 == 0 ? list.size() / 2 - 1 : list.size() / 2;

            if (targetIdx <= halfIdx) {
                for (int j = 0; j < targetIdx; j++) {
                    int temp = list.pollFirst();
                    list.offerLast(temp);
                    res++;
                }
            }
            else {
                for (int j = 0; j < list.size() - targetIdx; j++) {
                    int temp = list.pollLast();
                    list.offerFirst(temp);
                    res++;
                }
            }
            list.pollFirst();
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        POSITIONS = new int[M];
        for (int i = 0; i < M; i++) {
            POSITIONS[i] = SC.nextInt();
        }
    }
}
