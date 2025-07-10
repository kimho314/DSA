package boj;

import java.util.ArrayList;

public class BOJ2477 {
    private static FastReader SC = new FastReader();
    private static int K;
    private static ArrayList<Integer> LIST;
    private static int MAX_HEIGHT = 0, MAX_HEIGHT_IDX = 0, MAX_WIDTH = 0, MAX_WIDTH_IDX = 0;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int width = 0;
        if (MAX_WIDTH_IDX == 0) {
            width = Math.abs(LIST.get(5) - LIST.get(1));
        } else if (MAX_WIDTH_IDX == 5) {
            width = Math.abs(LIST.get(0) - LIST.get(4));
        } else {
            width = Math.abs(LIST.get(MAX_WIDTH_IDX + 1) - LIST.get(MAX_WIDTH_IDX - 1));
        }

        int height = 0;
        if (MAX_HEIGHT_IDX == 0) {
            height = Math.abs(LIST.get(5) - LIST.get(1));
        } else if (MAX_HEIGHT_IDX == 5) {
            height = Math.abs(LIST.get(4) - LIST.get(0));
        } else {
            height = Math.abs(LIST.get(MAX_HEIGHT_IDX + 1) - LIST.get(MAX_HEIGHT_IDX - 1));
        }

        int size = MAX_HEIGHT * MAX_WIDTH - height * width;
        System.out.println(size * K);
    }

    private static void input() {
        K = SC.nextInt();
        LIST = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int dir = SC.nextInt();
            int len = SC.nextInt();
            LIST.add(len);
            if (dir == 1 || dir == 2) {
                if (len > MAX_WIDTH) {
                    MAX_WIDTH = len;
                    MAX_WIDTH_IDX = i;
                }
            } else {
                if (len > MAX_HEIGHT) {
                    MAX_HEIGHT = len;
                    MAX_HEIGHT_IDX = i;
                }
            }
        }
    }
}
