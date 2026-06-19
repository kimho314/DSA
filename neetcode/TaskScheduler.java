package neetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler sol = new TaskScheduler();

        int res = sol.leastInterval(new char[]{'A', 'A', 'A', 'B', 'C'}, 3); // 9
        System.out.println(res);
        res = sol.leastInterval(new char[]{'X', 'X', 'Y', 'Y'}, 2); // 5
        System.out.println(res);
    }

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int['Z' - 'A' + 1];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt : count) {
            if (cnt > 0) {
                pq.add(cnt);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (pq.isEmpty()) {
                time = q.peek()[1];
            }
            else {
                int cnt = pq.poll() - 1;
                if (cnt > 0) {
                    q.add(new int[]{cnt, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                pq.add(q.poll()[0]);
            }
        }

        return time;
    }
}
