package boj;

import java.util.ArrayDeque;

public class BOJ13335 {
    private static FastReader SC = new FastReader();
    private static int N, W, L;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        int sum = 0;
        int time = 0;
        for (int i = 0; i < W; i++) {
            bridge.add(0);
        }

        int idx = 0;
        while (true) {
            time++;

            sum -= bridge.poll();
            int truck = A[idx];
            if (sum + truck <= L) {
                bridge.add(truck);
                sum += truck;
                if (++idx == N) {
                    break;
                }
            } else {
                bridge.add(0);
            }

        }

        time += bridge.size(); //다리에 남아있는 트럭들 건너는 시간 합함

        System.out.println(time);
    }

    private static void input() {
        N = SC.nextInt();
        W = SC.nextInt();
        L = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
