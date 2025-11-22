import java.util.*;
import java.math.*;

public class IslandsandTreasure {
    private int[][] dist;
    private boolean[][] visited;
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        IslandsandTreasure sol = new IslandsandTreasure();
        int[][] grid = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        sol.islandsAndTreasure(grid);
        print(grid);
    }

    private static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == Integer.MAX_VALUE) {
                    dist = new int[r][c];
                    visited = new boolean[r][c];
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    bfs(i, j, grid, pq);
                    int dist = pq.poll();
                    grid[i][j] = dist;
                }
            }
        }

    }

    private void bfs(int startY, int startX, int[][] grid, PriorityQueue<Integer> pq) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startY);
        q.add(startX);
        dist[startY][startX] = 0;
        visited[startY][startX] = true;

        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < 4; i++) {
                int dy = y + dir[i][0];
                int dx = x + dir[i][1];

                if (dy < 0 || dx < 0 || dy >= grid.length || dx >= grid[0].length) {
                    continue;
                }
                if (visited[dy][dx]) {
                    continue;
                }
                if (grid[dy][dx] == -1) {
                    dist[dy][dx] = -1;
                    continue;
                }

                visited[dy][dx] = true;
                dist[dy][dx] = dist[y][x] + 1;
                q.add(dy);
                q.add(dx);
                if (grid[dy][dx] == 0) {
                    pq.add(dist[dy][dx]);
                }
            }

        }
    }
}
