package neetcode;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    static void main() {
        KClosestPointsToOrigin sol = new KClosestPointsToOrigin();
        int[][] res = sol.kClosest(new int[][]{{0, 2}, {2, 2}}, 1);
        print(res);
        res = sol.kClosest(new int[][]{{0, 2}, {2, 0}, {2, 2}}, 2);
        print(res);
        res = sol.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        print(res);
        res = sol.kClosest(new int[][]{{0, 2}, {2, 2}}, 1);
        print(res);
    }

    private static void print(int[][] res) {
        for (int[] elem : res) {
            IO.println(elem[0] + "," + elem[1]);
        }
        IO.println();
    }

    class Data {
        public int dist;
        public int index;

        public Data(int dist, int index) {
            this.dist = dist;
            this.index = index;
        }

        @Override
        public String toString() {
            return dist + " " + index;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Data> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        for (int i = 0; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            Data data = new Data(dist, i);
            pq.add(data);
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Data data = pq.poll();
            res[i][0] = points[data.index][0];
            res[i][1] = points[data.index][1];
        }
        return res;
    }
}
