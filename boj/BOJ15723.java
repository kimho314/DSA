package boj;

import java.util.ArrayList;
import java.util.Arrays;

public class BOJ15723 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static ArrayList<Character>[] ADJ;
    private static boolean[] VISITED;
    private static ArrayList<ArrayList<Character>> ANSWERS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (ArrayList<Character> list : ANSWERS) {
            Arrays.fill(VISITED, false);
            char start = list.get(0);
            char end = list.get(1);

            dfs(start - 'a');

            if (VISITED[end - 'a']) {
                sb.append('T').append('\n');
            }
            else {
                sb.append('F').append('\n');
            }
        }

        System.out.println(sb);
    }

    private static void dfs(int x) {
        VISITED[x] = true;
        
        for (Character ch : ADJ[x]) {
            int dx = ch - 'a';

            if (VISITED[dx]) {
                continue;
            }

            dfs(dx);
        }
    }

    private static void input() {
        N = SC.nextInt();
        ADJ = new ArrayList['z' - 'a' + 1];
        for (int i = 0; i < ADJ.length; i++) {
            ADJ[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            String[] split = SC.nextLine().replaceAll(" ", "")
                    .replace("is", " ")
                    .split(" ");
            ADJ[split[0].charAt(0) - 'a'].add(split[1].charAt(0));
        }

        M = SC.nextInt();
        ANSWERS = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] split = SC.nextLine().replaceAll(" ", "")
                    .replace("is", " ")
                    .split(" ");
            ArrayList<Character> list = new ArrayList<>();
            list.add(split[0].charAt(0));
            list.add(split[1].charAt(0));
            ANSWERS.add(list);
        }
        VISITED = new boolean['z' - 'a' + 1];
    }
}
