package neetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        LastStoneWeight sol = new LastStoneWeight();
        int res = sol.lastStoneWeight(new int[]{2, 3, 6, 2, 4});
        System.out.println(res);
        res = sol.lastStoneWeight(new int[]{1, 2});
        System.out.println(res);
        res = sol.lastStoneWeight(new int[]{1, 1});
        System.out.println(res);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int elem : stones) {
            pq.add(elem);
        }
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x == y) {
                continue;
            }

            int tmp = 0;
            if (x > y) {
                tmp = x - y;
            }
            else {
                tmp = y - x;
            }
            pq.add(tmp);
        }

        if (pq.isEmpty()) {
            return 0;
        }
        return pq.peek();
    }
}
