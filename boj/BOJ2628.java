package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ2628 {
    private static FastReader SC = new FastReader();
    private static int W, H;
    private static int N;
    private static ArrayList<Integer> WIDTH, HEIGHT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        ArrayList<Integer> areas = new ArrayList<>();

        Collections.sort(WIDTH);
        Collections.sort(HEIGHT);

        int prevW = 0;
        for (int i = 0; i < WIDTH.size(); i++) {
            int w = WIDTH.get(i) - prevW;
            if (i == WIDTH.size() - 1) {
                w = W - prevW;
            }
            int prevH = 0;
            for (int j = 0; j < HEIGHT.size(); j++) {
                int h = HEIGHT.get(j) - prevH;
                if (j == HEIGHT.size() - 1) {
                    h = H - prevH;
                }
                int area = w * h;
//                System.out.println(prevW + " " + w + " " + prevH + " " + h + " " + area);
                areas.add(area);
                prevH = HEIGHT.get(j);
            }
            prevW = WIDTH.get(i);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(areas);
        int max = pq.poll();
        System.out.println(max);
    }

    private static void input() {
        W = SC.nextInt();
        H = SC.nextInt();
        N = SC.nextInt();
        WIDTH = new ArrayList<>();
        HEIGHT = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            if (n1 == 0) {
                HEIGHT.add(n2);
            }
            else {
                WIDTH.add(n2);
            }
        }
        WIDTH.add(W);
        HEIGHT.add(H);
    }
}
