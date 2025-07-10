package boj;

public class BOJ3584 {
    static FastReader SC = new FastReader();
    static int T, N;
    static int[] PARENT, CHECK;

    public static void main(String[] args) {
        T = SC.nextInt();

        while (T > 0) {
            T--;
            N = SC.nextInt();
            PARENT = new int[N + 1];
            CHECK = new int[N + 1];
            for (int i = 1; i < N; i++) {
                int u = SC.nextInt();
                int v = SC.nextInt();
                PARENT[v] = u;
            }

            int x = SC.nextInt();
            int y = SC.nextInt();

            while (x > 0) {
                CHECK[x] = 1;
                x = PARENT[x];
            }

            while (y > 0 && CHECK[y] == 0) {
                y = PARENT[y];
            }
            System.out.println(y);
        }
    }

}
