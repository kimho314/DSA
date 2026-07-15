package neetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    static void main() {
        WordLadder sol = new WordLadder();
        int res = sol.ladderLength("cat", "sag", List.of("bat", "bag", "sag", "dag", "dot"));
        IO.println(res);
        res = sol.ladderLength("cat", "sag", List.of("bat", "bag", "sat", "dag", "dot"));
        IO.println(res);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean flag = false;
        for (String elem : wordList) {
            if (elem.equals(endWord)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return 0;
        }

        int n = wordList.size() + 1;
        List<List<Integer>> adj = new ArrayList<>();
        String[] arr = new String[n];
        arr[0] = beginWord;
        for (int i = 1; i < n; i++) {
            arr[i] = wordList.get(i - 1);
        }
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int idx = -1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                String s1 = arr[i];
                String s2 = arr[j];
                int cnt = 0;
                for (int k = 0; k < s1.length(); k++) {
                    if (s1.charAt(k) != s2.charAt(k)) {
                        cnt++;
                    }
                }
                if (cnt == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        // StringBuilder sb = new StringBuilder();
        // for(int i=0; i<n; i++){
        //     sb.append(arr[i]).append(":");
        //     for(int elem : adj.get(i)){
        //         sb.append(arr[elem]).append(" ");
        //     }
        //     sb.append("\n");
        // }
        // System.out.println(sb.toString());

        boolean[] visit = new boolean[n];
        int[] dist = new int[n];
        bfs(0, visit, dist, adj);

        for (int i = 0; i < n; i++) {
            if (arr[i].equals(endWord)) {
                return dist[i];
            }
        }
        return 0;
    }

    private void bfs(int start, boolean[] visit, int[] dist, List<List<Integer>> adj) {
        visit[start] = true;
        dist[start] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int elem : adj.get(node)) {
                if (visit[elem]) {
                    continue;
                }
                visit[elem] = true;
                dist[elem] = dist[node] + 1;
                q.add(elem);
            }
        }
    }
}
