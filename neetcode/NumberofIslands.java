public class NumberofIslands {
    private int cnt;
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;

    public static void main(String[] args) {
        NumberofIslands sol = new NumberofIslands();
        int res = sol.numIslands(new char[][] {{'0', '1', '1', '1', '0'}, {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
        System.out.println(res);
        res = sol.numIslands(new char[][] {{'1', '1', '0', '0', '1'}, {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}});
        System.out.println(res);
    };

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return cnt;
        }

        cnt = 0;
        int r = grid.length;
        int c = grid[0].length;
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void dfs(int y, int x, char[][] map) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int dy = y + dir[i][0];
            int dx = x + dir[i][1];

            if (dy < 0 || dx < 0 || dy >= map.length || dx >= map[0].length) {
                continue;
            }
            if (map[dy][dx] == '0' || visited[dy][dx]) {
                continue;
            }

            dfs(dy, dx, map);
        }
    }
}
