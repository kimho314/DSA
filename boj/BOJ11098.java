package boj;

import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11098 {
    private static FastReader SC = new FastReader();
    private static int N;

    private static class Player implements Comparable<Player> {
        public String name;
        public int price;

        public Player(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public int compareTo(Player o) {
            return this.price - o.price;
        }
    }

    public static void main(String[] args) {
        input();

        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            N--;

            Player p = solve();
            sb.append(p.name).append("\n");
        }

        System.out.println(sb);
    }

    private static Player solve() {
        PriorityQueue<Player> pq = new PriorityQueue<>(Collections.reverseOrder());
        int p = SC.nextInt();
        for (int i = 0; i < p; i++) {
            int price = SC.nextInt();
            String name = SC.next();
            Player player = new Player(name, price);
            pq.add(player);
        }

        return pq.poll();
    }

    private static void input() {
        N = SC.nextInt();
    }
}
