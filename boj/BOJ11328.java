package boj;

public class BOJ11328 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            N--;

            String str1 = SC.next();
            String str2 = SC.next();

            if (str1.length() != str2.length()) {
                sb.append("Impossible").append("\n");
                continue;
            }
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();
            boolean[] visited = new boolean[chars1.length];
            for (int i = 0; i < chars1.length; i++) {
                for (int j = 0; j < chars2.length; j++) {
                    if (chars1[i] == chars2[j] && !visited[j]) {
                        visited[j] = true;
                        break;
                    }
                }
            }

            int cnt = 0;
            for (int i = 0; i < chars1.length; i++) {
                if (visited[i]) {
                    cnt++;
                }
            }
            if (cnt == chars1.length) {
                sb.append("Possible").append("\n");
            }
            else {
                sb.append("Impossible").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
