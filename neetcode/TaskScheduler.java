import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler sol = new TaskScheduler();

        int res = sol.leastInterval(new char[] {'A', 'A', 'A', 'B', 'C'}, 3);
        System.out.println(res);
        res = sol.leastInterval(new char[] {'X', 'X', 'Y', 'Y'}, 2);
        System.out.println(res);
    }

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt : count) {
            if (cnt > 0) {
                maxHeap.add(cnt);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    q.add(new int[] {cnt, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}
