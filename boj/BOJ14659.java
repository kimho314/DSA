package boj;

public class BOJ14659 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] PEAKS;

    public static void main(String[] args) {
        N = SC.nextInt();
        PEAKS = new int[N];
        for (int i = 0; i < N; i++) {
            PEAKS[i] = SC.nextInt();
        }

        int maxEnemies = 0;
        for (int i = 0; i < N - 1; i++) {
            int enemies = 0;
            for (int j = i + 1; j < N; j++) {
                if (PEAKS[i] <= PEAKS[j]) {
                    break;
                }
                enemies++;
            }
            maxEnemies = Math.max(enemies, maxEnemies);
        }
        System.out.println(maxEnemies);
    }
}
