package boj;

import java.util.*;

public class BOJ9079 {
    private static FastReader SC = new FastReader();
    private static int T;

    private static class State {
        String[][] graph;
        int count;

        State(String[][] graph, int count) {
            this.graph = new String[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    this.graph[i][j] = graph[i][j];
                }
            }
            this.count = count;
        }
    }

    private static boolean checkAll(String[][] graph) {
        String first = graph[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!graph[i][j].equals(first)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String graphToString(String[][] graph) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(graph[i][j]);
            }
        }
        return sb.toString();
    }

    private static String[][] copyGraph(String[][] original) {
        String[][] copy = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        T = SC.nextInt();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        while (T > 0) {
            T--;

            String[][] graph = new String[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = SC.next();
                }
            }

            int res = bfs(graph);
            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(String[][] graph) {
        String start = graphToString(graph);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(graph, 0));

        while (!queue.isEmpty()) {
            State current = queue.poll();
            String[][] currentGraph = current.graph;
            int count = current.count;

            if (checkAll(currentGraph)) {
                return count;
            }

            // 행 뒤집기
            for (int i = 0; i < 3; i++) {
                String[][] temp = copyGraph(currentGraph);
                for (int j = 0; j < 3; j++) {
                    if (currentGraph[i][j].equals("H")) {
                        temp[i][j] = "T";
                    } else {
                        temp[i][j] = "H";
                    }
                }
                String newGraphStr = graphToString(temp);
                if (!visited.contains(newGraphStr)) {
                    visited.add(newGraphStr);
                    queue.offer(new State(temp, count + 1));
                }
            }

            // 열 뒤집기
            for (int i = 0; i < 3; i++) {
                String[][] temp = copyGraph(currentGraph);
                for (int j = 0; j < 3; j++) {
                    if (currentGraph[j][i].equals("H")) {
                        temp[j][i] = "T";
                    } else {
                        temp[j][i] = "H";
                    }
                }
                String newGraphStr = graphToString(temp);
                if (!visited.contains(newGraphStr)) {
                    visited.add(newGraphStr);
                    queue.offer(new State(temp, count + 1));
                }
            }

            // 왼쪽 위 -> 오른쪽 아래 대각선 뒤집기
            String[][] temp1 = copyGraph(currentGraph);
            for (int i = 0; i < 3; i++) {
                if (currentGraph[i][i].equals("H")) {
                    temp1[i][i] = "T";
                } else {
                    temp1[i][i] = "H";
                }
            }
            String newGraphStr1 = graphToString(temp1);
            if (!visited.contains(newGraphStr1)) {
                visited.add(newGraphStr1);
                queue.offer(new State(temp1, count + 1));
            }

            // 오른쪽 위 -> 왼쪽 아래 대각선 뒤집기
            String[][] temp2 = copyGraph(currentGraph);
            for (int i = 0; i < 3; i++) {
                if (currentGraph[i][2 - i].equals("H")) {
                    temp2[i][2 - i] = "T";
                } else {
                    temp2[i][2 - i] = "H";
                }
            }
            String newGraphStr2 = graphToString(temp2);
            if (!visited.contains(newGraphStr2)) {
                visited.add(newGraphStr2);
                queue.offer(new State(temp2, count + 1));
            }
        }

        return -1;
    }
}
