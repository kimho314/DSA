import java.util.*;

public class LastStoneWeight {
    public static void main(String[] args) {
        LastStoneWeight sol = new LastStoneWeight();
        int res = sol.lastStoneWeight(new int[] {2, 3, 6, 2, 4});
        System.out.println(res);
        res = sol.lastStoneWeight(new int[] {1, 2});
        System.out.println(res);
        res = sol.lastStoneWeight(new int[] {1, 1});
        System.out.println(res);
    }

    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int elem : stones) {
            pq.add(elem);
        }

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x == y) {
                continue;
            }

            if (x > y) {
                x = x - y;
                pq.add(x);
            } else {
                y = y - x;
                pq.add(y);
            }
        }

        if (pq.isEmpty()) {
            return 0;
        } else {
            return pq.poll();
        }
    }
}
