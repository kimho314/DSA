import java.util.*;

public class PacificAtlanticWaterFlow {
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;

    public static void main(String[] args) {
        PacificAtlanticWaterFlow sol = new PacificAtlanticWaterFlow();
        List<List<Integer>> res = sol
                .pacificAtlantic(new int[][] {{4, 2, 7, 3, 4}, {7, 4, 6, 4, 7}, {6, 3, 5, 3, 6}});
        print(res);
        res = sol.pacificAtlantic(new int[][] {{1}, {1}});
        print(res);
    }

    private static void print(List<List<Integer>> list) {
        for (List<Integer> outer : list) {
            for (Integer inner : outer) {
                System.out.print(inner + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public List<List<Integer>> pacificAtlantic2(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            dfs2(0, c, pac, heights);
            dfs2(ROWS - 1, c, atl, heights);
        }
        for (int r = 0; r < ROWS; r++) {
            dfs2(r, 0, pac, heights);
            dfs2(r, COLS - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void dfs2(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;
        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length
                    && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, ocean, heights);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        List<int[]> pacificList = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            pacificList.add(new int[] {0, i});
        }
        for (int i = 0; i < r; i++) {
            pacificList.add(new int[] {i, 0});
        }
        List<int[]> atlanticList = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            atlanticList.add(new int[] {r - 1, i});
        }
        for (int i = 0; i < r; i++) {
            atlanticList.add(new int[] {i, c - 1});
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                visited = new boolean[r][c];
                bfs(i, j, heights);
                boolean isPacific = false;
                Boolean isAtlantic = false;
                for (int[] elem : pacificList) {
                    if (visited[elem[0]][elem[1]]) {
                        isPacific = true;
                        break;
                    }
                }
                for (int[] elem : atlanticList) {
                    if (visited[elem[0]][elem[1]]) {
                        isAtlantic = true;
                        break;
                    }
                }
                if (isPacific && isAtlantic) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(int startY, int startX, int[][] map) {
        visited[startY][startX] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startY, startX});

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int dy = pos[0] + dir[i][0];
                int dx = pos[1] + dir[i][1];

                if (dy < 0 || dx < 0 || dy >= map.length || dx >= map[0].length) {
                    continue;
                }
                if (visited[dy][dx] || map[dy][dx] > map[pos[0]][pos[1]]) {
                    continue;
                }

                visited[dy][dx] = true;
                q.add(new int[] {dy, dx});
            }
        }
    }
}
