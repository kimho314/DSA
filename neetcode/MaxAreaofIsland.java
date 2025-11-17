public class MaxAreaofIsland {
    private int area;
    private int maxCnt;
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;

    public static void main(String[] args) {
        MaxAreaofIsland sol = new MaxAreaofIsland();
        int res = sol.maxAreaOfIsland(
                new int[][] {{0, 1, 1, 0, 1}, {1, 0, 1, 0, 1}, {0, 1, 1, 0, 1}, {0, 1, 0, 0, 1}});
        System.out.println(res);
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        maxCnt = 0;
        int r = grid.length;
        int c = grid[0].length;
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    area = 0;
                    dfs(i, j, grid);
                    maxCnt = Math.max(maxCnt, area);
                }
            }
        }

        return maxCnt;
    }

    private void dfs(int y, int x, int[][] grid) {
        if (grid[y][x] == 1) {
            area++;
        }
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int dy = y + dir[i][0];
            int dx = x + dir[i][1];

            if (dy < 0 || dx < 0 || dy >= grid.length || dx >= grid[0].length) {
                continue;
            }
            if (visited[dy][dx] || grid[dy][dx] == 0) {
                continue;
            }

            dfs(dy, dx, grid);
        }
    }
}
