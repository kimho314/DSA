import java.util.*;

public class RottingFruit {
    private boolean[][] visited;
    private int[][] dist;
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        RottingFruit sol = new RottingFruit();
        int res = sol.orangesRotting(new int[][] {{1, 1, 0}, {0, 1, 1}, {0, 1, 2}});
        System.out.println(res);
        res = sol.orangesRotting(new int[][] {{1, 0, 1}, {0, 2, 0}, {1, 0, 1}});
        System.out.println(res);
        res = sol.orangesRotting(new int[][] {{0}});
        System.out.println(res);
    }

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int res = -1;
        int r = grid.length;
        int c = grid[0].length;
        visited = new boolean[r][c];
        dist = new int[r][c];

        dfs(r, c, grid);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }

                res = Math.max(res, dist[i][j]);
            }
        }

        return res;
    }

    private void dfs(int r, int c, int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }


        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int dy = pos[0] + dir[i][0];
                int dx = pos[1] + dir[i][1];

                if (dy < 0 || dx < 0 || dy >= r || dx >= c) {
                    continue;
                }
                if (visited[dy][dx] || grid[dy][dx] == 0) {
                    continue;
                }

                visited[dy][dx] = true;
                dist[dy][dx] = dist[pos[0]][pos[1]] + 1;
                grid[dy][dx] = 2;

                q.add(new int[] {dy, dx});
            }
        }
    }
}
