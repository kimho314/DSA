package boj;

public class BOJ3009 {
    static FastReader SC = new FastReader();
    static int[][] POSES = new int[3][2];

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int x = SC.nextInt();
            int y = SC.nextInt();
            POSES[i][0] = x;
            POSES[i][1] = y;
        }

        int x = -1;
        for (int i = 0; i < 3; i++) {
            boolean isDup = false;
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }

                if (POSES[i][0] == POSES[j][0]) {
                    isDup = true;
                    break;
                }
            }
            if (!isDup) {
                x = POSES[i][0];
                break;
            }
        }


        int y = -1;
        for (int i = 0; i < 3; i++) {
            boolean isDup = false;
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }

                if (POSES[i][1] == POSES[j][1]) {
                    isDup = true;
                    break;
                }
            }
            if (!isDup) {
                y = POSES[i][1];
                break;
            }
        }

        System.out.println(x + " " + y);
    }
}
