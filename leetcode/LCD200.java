package leetcode;

import java.util.*;

public class LCD200 {
    private boolean[][] visited;
    private ArrayList<Integer> group = new ArrayList<>();
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int cnt = 0;

    public static void main(String[] args) {
        LCD200 sol = new LCD200();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(sol.numIslands(grid));
    }


    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (!visited[i][j] && grid[i][j] == '1') {
                    cnt = 0;
                    dfs(i, j, grid.length, grid[0].length, grid);
                    group.add(cnt);
                }
            }
        }

        return group.size();
    }

    private void dfs(int y, int x, int height, int width, char[][] grid) {
        cnt++;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int dy = y + dir[i][0];
            int dx = x + dir[i][1];
            if (dy < 0 || dx < 0 || dy >= height || dx >= width) {
                continue;
            }
            if (visited[dy][dx] || grid[dy][dx] == '0') {
                continue;
            }

            dfs(dy, dx, height, width, grid);
        }
    }
}
