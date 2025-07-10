package boj;

public class BOJ1138 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] PEOPLE;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (result[j] == 0) {
                    if (cnt == PEOPLE[i]) {
                        result[j] = i + 1;
                        break;
                    }
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static void input() {
        N = SC.nextInt();
        PEOPLE = new int[N];
        for (int i = 0; i < N; i++) {
            PEOPLE[i] = SC.nextInt();
        }
    }
}
